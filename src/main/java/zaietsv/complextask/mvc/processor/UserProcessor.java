package zaietsv.complextask.mvc.processor;

import zaietsv.complextask.mvc.connect.MusicUserConnector;
import zaietsv.complextask.mvc.dao.UserDAO;
import zaietsv.complextask.mvc.holder.UserHolder;
import zaietsv.complextask.mvc.instance.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by Voww on 18.09.2015.
 */
public class UserProcessor extends AbstractProcessor {
/*
    public UserProcessor() {
    }*/

    public UserProcessor(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        super(request, response, "user", new UserDAO(new MusicUserConnector().getConnection()), new UserHolder());
        
    }

    @Override
    public UserHolder process() {
        String action = request.getParameter("action");
        action = action == null ? "" : action;
        System.out.println(this.getClass().getName() + " > action = " + action);

        switch (action) {
            case "insert":
                //System.out.println("case 'insert':");
                String login = request.getParameter("login");
                String password = request.getParameter("password");
                String email = request.getParameter("email");
                User newUser = new User(login, password, email);
                dao.insert(newUser);

                break;
            case "edit":
                System.out.println("case 'edit':");
                break;
            case "update":
                System.out.println("case 'update':");
                Long id = Long.parseLong(request.getParameter("id"));
                login = request.getParameter("login");
                password = request.getParameter("password");
                email = request.getParameter("email");
                User updateUser = new User(id, login, password, email);
                System.out.println(updateUser);
                System.out.println(dao.update(updateUser));
                break;
            case "delete":
                System.out.println("case delete:");
                id = Long.parseLong(request.getParameter("id"));
                System.out.println(dao.delete(id));
                break;

            default:
                System.out.println("default:");
                break;
        }

        this.holder.setList(dao.readAll());
        request.getSession().setAttribute("userHolder", this.holder);
        return (UserHolder)this.holder;
    }
}
