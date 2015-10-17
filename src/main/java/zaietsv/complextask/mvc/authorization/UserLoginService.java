package zaietsv.complextask.mvc.authorization;

import zaietsv.complextask.mvc.dao.UserAddressRoleMusicsDAO;
import zaietsv.complextask.mvc.dao.data_acces_object.UserDAO;
import zaietsv.complextask.mvc.entity.UserAddressRoleMusics;
import zaietsv.complextask.mvc.entity.instance.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Voww on 17.10.2015.
 */
public class UserLoginService extends AbstractLogin {

    public UserLoginService() {
    }

    public UserLoginService(HttpServletRequest request) {
        super(request);
    }

    @Override
    public boolean login(User user) {
        UserDAO udao = new UserDAO(connection);
        UserAddressRoleMusicsDAO uarmDAO = new UserAddressRoleMusicsDAO(connection);
        Boolean success = false;
        if (udao.readByLoginAndPassword(user) > 0) {
            UserAddressRoleMusics uarm = uarmDAO.read(user.getId());
            if (uarm != null) {
                HttpSession session = request.getSession();
                session.setAttribute("loggedUser", uarm);
                success = true;
            }
        }
        return success;
    }

    @Override
    public boolean logout() {
        UserAddressRoleMusics uarm = (UserAddressRoleMusics) request.getSession().getAttribute("loggedUser");
        Boolean success = false;
        if (uarm != null) {
            request.getSession().removeAttribute("loggedUser");
            success = true;
        }
        return success;
    }

    public UserAddressRoleMusics getLoggedUser() {
        return (UserAddressRoleMusics) request.getSession().getAttribute("loggedUser");
    }
}
