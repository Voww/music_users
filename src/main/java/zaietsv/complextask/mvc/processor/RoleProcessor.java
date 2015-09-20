package zaietsv.complextask.mvc.processor;

import zaietsv.complextask.mvc.connect.MusicUserConnector;
import zaietsv.complextask.mvc.dao.RoleDAO;
import zaietsv.complextask.mvc.holder.RoleHolder;
import zaietsv.complextask.mvc.instance.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by Voww on 18.09.2015.
 */
public class RoleProcessor extends AbstractProcessor {
/*
    public RoleProcessor() {
    }*/

    public RoleProcessor(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        super(request, response, "role", new RoleDAO(new MusicUserConnector().getConnection()), new RoleHolder());
        
    }

    @Override
    public RoleHolder process() {
        String action = request.getParameter("action");
        action = action == null ? "" : action;
        System.out.println(this.getClass().getName() + " > action = " + action);

        switch (action) {
            case "insert":
                System.out.println("case 'insert':");
                String name = request.getParameter("name");
                Role newRole = new Role(name);
                dao.insert(newRole);

                break;
            case "edit":
                System.out.println("case 'edit':");
                break;
            case "update":
                System.out.println("case 'update':");
                Long id = Long.parseLong(request.getParameter("id"));
                name = request.getParameter("name");
                Role updateRole = new Role(id, name);
                System.out.println(updateRole);
                System.out.println(dao.update(updateRole));
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
        request.getSession().setAttribute("roleHolder", this.holder);
        return (RoleHolder)this.holder;
    }
}
