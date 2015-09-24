package zaietsv.complextask.mvc.processor;

import zaietsv.complextask.mvc.connect.MusicUserConnector;
import zaietsv.complextask.mvc.dao.data_acces_instance.RoleDAI;
import zaietsv.complextask.mvc.entity.instance.Role;
import zaietsv.complextask.mvc.entity.instance.Roles;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by Voww on 18.09.2015.
 */
public class RolesProcessor extends AbstractInstancesProcessor {
/*
    public RoleProcessor() {
    }*/

    public RolesProcessor(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        super(request, response, "role", new RoleDAI(new MusicUserConnector().getConnection()), new Roles());
        
    }

    @Override
    public Roles process() {
        String action = request.getParameter("action");
        action = action == null ? "" : action;
        System.out.println(this.getClass().getName() + " > action = " + action);

        switch (action) {
            case "insert":
                System.out.println("case 'insert':");
                String name = request.getParameter("name");
                Role newRole = new Role(name);
                dai.insert(newRole);

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
                System.out.println(dai.update(updateRole));
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
        request.getSession().setAttribute("roles", this.instances);
        return (Roles)this.instances;
    }
}
