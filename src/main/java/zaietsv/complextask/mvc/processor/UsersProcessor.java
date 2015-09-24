package zaietsv.complextask.mvc.processor;

import zaietsv.complextask.mvc.connect.MusicUserConnector;
import zaietsv.complextask.mvc.dao.data_acces_instance.UserDAI;
import zaietsv.complextask.mvc.entity.instance.User;
import zaietsv.complextask.mvc.entity.instance.Users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class UsersProcessor extends AbstractInstancesProcessor {
/*
    public UsersProcessor() {
    }*/

    public UsersProcessor(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        super(request, response, "user", new UserDAI(new MusicUserConnector().getConnection()), new Users());
        
    }

    @Override
    public Users process() {
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
                dai.insert(newUser);

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
                System.out.println(dai.update(updateUser));
                break;
            case "delete":
                System.out.println("case delete:");
                id = Long.parseLong(request.getParameter("id"));
                System.out.println(dai.delete(id));
                break;
            case "details":
                System.out.println("case details:");
                //id = Long.parseLong(request.getParameter("id"));
                //System.out.println(dao.delete(id));
                break;
            default:
                System.out.println("default:");
                break;
        }

        this.instances.setInstances(dai.readAll());
        request.getSession().setAttribute("users", this.instances);
        return (Users)this.instances;
    }
}
