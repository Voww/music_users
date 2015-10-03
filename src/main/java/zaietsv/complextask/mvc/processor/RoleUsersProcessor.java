package zaietsv.complextask.mvc.processor;

import zaietsv.complextask.mvc.connect.MusicUserConnector;
import zaietsv.complextask.mvc.dao.data_access_object_detail.RoleUsersDAODs;
import zaietsv.complextask.mvc.entity.instance.Role;
import zaietsv.complextask.mvc.entity.instance.User;
import zaietsv.complextask.mvc.entity.instance.Users;
import zaietsv.complextask.mvc.entity.instance_detail.RoleUsers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by Voww on 18.09.2015.
 */
public class RoleUsersProcessor extends AbstractInstanceDetailsProcessor {

    public RoleUsersProcessor() {
    }

    public RoleUsersProcessor(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws SQLException {
        super(servletRequest, servletResponse, "role_users", new RoleUsersDAODs(new MusicUserConnector().getConnection(servletRequest)), new RoleUsers());
    }

    @Override
    public String process() {
        String action = request.getParameter("action");
        action = action == null ? "" : action;

        switch (action) {
            case "insert":
                String str_id = request.getParameter("id");

                String login = request.getParameter("login");
                String password = request.getParameter("password");
                String email = request.getParameter("email");
                Users newUsers = new Users();
                newUsers.getInstances().add(new User(login, password, email));
                if (str_id == null) {
                    String name = request.getParameter("name");
                    Role newRole = new Role(name);
                    RoleUsers roleUsers = new RoleUsers(newRole, newUsers);
                    daods.insert(roleUsers);
                    daods.read(roleUsers);
                    request.getSession().setAttribute("roleUsers", roleUsers);
                } else {
                    Long id = Long.parseLong(str_id);
                    daods.insert(id, newUsers);
                }
                break;
            case "edit":
                System.out.println("case 'edit':");
                break;
            case "update":
                System.out.println("case 'update':");
                Role updateRole = null;
                String str_role_id = request.getParameter("role_id");
                if (str_role_id != null) {
                    Long role_id = Long.parseLong(str_role_id);
                    String name = request.getParameter("name");
                    updateRole = new Role(role_id, name);
                }
                Users updateUsers = new Users();
                String str_user_id = request.getParameter("user_id");
                if (str_user_id != null) {
                    Long user_id = Long.parseLong(str_user_id);
                    login = request.getParameter("login");
                    password = request.getParameter("password");
                    email = request.getParameter("email");

                    updateUsers.getInstances().add(new User(user_id, login, password, email));
                }
                System.out.println(daods.update(new RoleUsers(updateRole, updateUsers)));
                break;
            case "unlink":
                System.out.println("case unlink:");
                str_id = request.getParameter("id");
                str_user_id = request.getParameter("user_id");
                if (str_id != null && str_user_id != null) {
                    daods.unlink(Long.parseLong(str_id), Long.parseLong(str_user_id));
                } else if (str_id != null) {
                    System.out.println(daods.unlink(Long.parseLong(str_id)));
                }
                break;
            case "delete":
                System.out.println("case delete:");
                str_id = request.getParameter("id");
                Long id = 0L;
                if (str_id != null) {
                    id = Long.parseLong(str_id);
                }
                str_user_id = request.getParameter("user_id");
                Long user_id = 0L;
                if (str_user_id != null) {
                    user_id = Long.parseLong(str_user_id);
                }
                daods.delete(id, user_id);
                break;
            default:
                System.out.println("default:");
                break;
        }
        String str_id = request.getParameter("id");
        if (str_id != null) {
            instanceDetails = daods.read(Long.parseLong(str_id));
            System.out.println("instanceDetails=" + instanceDetails);
            if (instanceDetails == null) {
                request.getSession().removeAttribute("roleUsers");
            } else {
                request.getSession().setAttribute("roleUsers", instanceDetails);
            }
        }
        return "admin/role_users_table.jsp";
    }
}
