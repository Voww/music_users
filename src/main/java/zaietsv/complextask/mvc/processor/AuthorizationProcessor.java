package zaietsv.complextask.mvc.processor;

import zaietsv.complextask.mvc.authorization.UserLoginService;
import zaietsv.complextask.mvc.dao.UserAddressRoleMusicsDAO;
import zaietsv.complextask.mvc.entity.UserAddressRoleMusics;
import zaietsv.complextask.mvc.entity.instance.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Voww on 17.10.2015.
 */
public class AuthorizationProcessor extends AbstractProcessor<UserAddressRoleMusics> {

    public AuthorizationProcessor() {
    }

    public AuthorizationProcessor(HttpServletRequest servletRequest, HttpServletResponse servletResponse, String table, UserAddressRoleMusicsDAO dao, UserAddressRoleMusics uarm) {
        super(servletRequest, servletResponse, table, dao, uarm);
    }

    @Override
    public String process() {
        String returnLink = "index.jsp";
        String action = request.getParameter("action");
        action = action == null ? "" : action;

        switch (action) {
            case "login":

                String login = request.getParameter("login");
                String password = request.getParameter("password");
                User loggingUser = new User();
                if (login != null && password != null) {
                    loggingUser.setLogin(login);
                    loggingUser.setPassword(password);
                    UserLoginService uls = new UserLoginService();
                    if (uls.login(loggingUser)) {
                        switch (uls.getLoggedUser().getRole().getName()) {
                            case "admin":
                                returnLink = "admin.jsp";
                                break;
                            case "mandator":
                                returnLink = "mandator.jsp";
                                break;
                            case "user":
                                returnLink = "user.jsp";
                                break;
                        }

                    }
                }
                break;
            case "logout":
                break;
            case "register":
                break;
            case "unregister":
                break;
            default:
                break;
        }
        UserLoginService uls = new UserLoginService();
        return returnLink;
    }
}
