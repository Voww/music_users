package zaietsv.complextask.mvc.processor.instance_processor;

import zaietsv.complextask.mvc.connect.MusicUserConnector;
import zaietsv.complextask.mvc.dao.data_acces_object.UserDAO;
import zaietsv.complextask.mvc.entity.instance.User;
import zaietsv.complextask.mvc.entity.instance.Users;
import zaietsv.complextask.mvc.exception.ConnectionException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsersProcessor extends AbstractInstancesProcessor {
/*
    public UsersProcessor() {
    }*/

    public UsersProcessor(HttpServletRequest request, HttpServletResponse response) throws ConnectionException {
        super(request, response, "user", new UserDAO(new MusicUserConnector().getConnection(request)), new Users());
        
    }

    @Override
    public String process() {
        String action = request.getParameter("action");
        action = action == null ? "" : action;

        switch (action) {
            case "insert":
                String login = request.getParameter("login");
                String password = request.getParameter("password");
                String email = request.getParameter("email");
                User newUser = new User(login, password, email);
                dao.insert(newUser);

                break;
            case "edit":
                break;
            case "update":
                Long id = Long.parseLong(request.getParameter("id"));
                login = request.getParameter("login");
                password = request.getParameter("password");
                email = request.getParameter("email");
                User updateUser = new User(id, login, password, email);
                dao.update(updateUser);
                break;
            case "delete":
                id = Long.parseLong(request.getParameter("id"));
                dao.delete(id);
                break;
            case "details":
                //id = Long.parseLong(request.getParameter("id"));
                //dao.delete(id);
                break;
            default:
                break;
        }

        this.instances.setInstances(dao.readAll());
        request.getSession().setAttribute("users", this.instances);
        return "users_table.jsp";
    }
}
