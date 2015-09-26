package zaietsv.complextask.mvc.processor;

import zaietsv.complextask.mvc.connect.MusicUserConnector;
import zaietsv.complextask.mvc.dao.data_access_instance_detail.AddressUserDAID;
import zaietsv.complextask.mvc.entity.instance.Address;
import zaietsv.complextask.mvc.entity.instance.User;
import zaietsv.complextask.mvc.entity.instance_detail.AddressUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Voww on 18.09.2015.
 */
public class AddressUserProcessor extends AbstractInstanceDetailProcessor {

    public AddressUserProcessor() {
    }

    public AddressUserProcessor(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws SQLException {
        super(servletRequest, servletResponse, "address_user", new AddressUserDAID(new MusicUserConnector().getConnection()), new AddressUser());
    }

    @Override
    public AddressUser process() {
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

                daid.insert(new AddressUser(newAddress, newUser));

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

                System.out.println(daid.update(new AddressUser(updateAddress, updateUser)));
                break;
            case "delete":
                System.out.println("case delete:");
                address_id = Long.parseLong(request.getParameter("address_id"));
                System.out.println(daid.delete(address_id));
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
        instanceDetail = daid.read(Long.parseLong(request.getParameter("address_id")));
        System.out.println("instanceDetail=" + instanceDetail);

        RequestDispatcher rd = request.getRequestDispatcher("admin/address_user_table.jsp");
        //request.getSession().setAttribute("addressUser", new AddressUser());
        request.getSession().setAttribute("addressUser", instanceDetail);
        try {
            rd.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (AddressUser)this.instanceDetail;
    }
}
