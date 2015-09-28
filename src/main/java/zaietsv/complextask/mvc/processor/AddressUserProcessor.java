package zaietsv.complextask.mvc.processor;

import zaietsv.complextask.mvc.connect.MusicUserConnector;
import zaietsv.complextask.mvc.dao.data_access_object_detail.AddressUserDAOD;
import zaietsv.complextask.mvc.entity.instance.Address;
import zaietsv.complextask.mvc.entity.instance.User;
import zaietsv.complextask.mvc.entity.instance_detail.AddressUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by Voww on 18.09.2015.
 */
public class AddressUserProcessor extends AbstractInstanceDetailProcessor {

    public AddressUserProcessor() {
    }

    public AddressUserProcessor(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws SQLException {
        super(servletRequest, servletResponse, "address_user", new AddressUserDAOD(new MusicUserConnector().getConnection(servletRequest)), new AddressUser());
    }

    @Override
    public String process() {
        String action = request.getParameter("action");
        action = action == null ? "" : action;
        System.out.println(this.getClass().getName() + " > action = " + action);

        switch (action) {
            case "insert":
                //System.out.println("case 'insert':");
                int postcode = Integer.parseInt(request.getParameter("postcode"));
                String city = request.getParameter("city");
                String street = request.getParameter("street");
                int house = Integer.parseInt(request.getParameter("house"));
                int flat = Integer.parseInt(request.getParameter("flat"));
                Address newAddress = new Address(postcode, city, street, house, flat);
                System.out.println("newAddress=" + newAddress);

                String login = request.getParameter("login");
                String password = request.getParameter("password");
                String email = request.getParameter("email");
                User newUser = new User(login, password, email);
                System.out.println("newUser=" + newUser);

                daod.insert(new AddressUser(newAddress, newUser));

                break;
            case "edit":
                System.out.println("case 'edit':");
                break;
            case "update":
                System.out.println("case 'update':");
                Long address_id = Long.parseLong(request.getParameter("address_id"));
                postcode = Integer.parseInt(request.getParameter("postcode"));
                city = request.getParameter("city");
                street = request.getParameter("street");
                house = Integer.parseInt(request.getParameter("house"));
                flat = Integer.parseInt(request.getParameter("flat"));
                Address updateAddress = new Address(address_id, postcode, city, street, house, flat);

                Long user_id = Long.parseLong(request.getParameter("user_id"));
                login = request.getParameter("login");
                password = request.getParameter("password");
                email = request.getParameter("email");
                User updateUser = new User(user_id, login, password, email);

                System.out.println(daod.update(new AddressUser(updateAddress, updateUser)));
                break;
            case "delete":
                System.out.println("case delete:");
                address_id = Long.parseLong(request.getParameter("address_id"));
                System.out.println(daod.delete(address_id));
                break;
            /*case "details":
                System.out.println("case details:");
                //id = Long.parseLong(request.getParameter("id"));
                //System.out.println(dao.delete(id));
                break;*/

            default:
                System.out.println("default:");
                break;
        }
        instanceDetail = daod.read(Long.parseLong(request.getParameter("id")));
        System.out.println("instanceDetail=" + instanceDetail);
        request.getSession().setAttribute("addressUser", instanceDetail);
        return "admin/address_user_table.jsp";
    }
}
