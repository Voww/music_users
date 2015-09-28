package zaietsv.complextask.mvc.processor;

import zaietsv.complextask.mvc.connect.MusicUserConnector;
import zaietsv.complextask.mvc.dao.data_acces_object.AddressDAO;
import zaietsv.complextask.mvc.entity.instance.Address;
import zaietsv.complextask.mvc.entity.instance.Addresses;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by Voww on 18.09.2015.
 */
public class AddressesProcessor extends AbstractInstancesProcessor {

    public AddressesProcessor() {
    }

    public AddressesProcessor(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws SQLException {
        super(servletRequest, servletResponse, "address", new AddressDAO(new MusicUserConnector().getConnection(servletRequest)), new Addresses());
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
                dao.insert(newAddress);

                break;
            case "edit":
                System.out.println("case 'edit':");
                break;
            case "update":
                System.out.println("case 'update':");
                Long id = Long.parseLong(request.getParameter("id"));
                postcode = Integer.parseInt(request.getParameter("postcode"));
                city = request.getParameter("city");
                street = request.getParameter("street");
                house = Integer.parseInt(request.getParameter("house"));
                flat = Integer.parseInt(request.getParameter("flat"));
                Address updateAddress = new Address(id, postcode, city, street, house, flat);
                System.out.println("id=" + id);
                System.out.println(dao.update(updateAddress));
                break;
            case "delete":
                System.out.println("case delete:");
                id = Long.parseLong(request.getParameter("id"));
                System.out.println(dao.delete(id));
                break;
            case "details":
                System.out.println("case details:");
                InstanceDetailProcessor idp = null;
                try {
                    idp = new AddressUserProcessor(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                idp.process();
                break;

            default:
                System.out.println("default:");
                break;
        }

        this.instances.setInstances(dao.readAll());
        request.getSession().setAttribute("addresses", this.instances);
        return "admin/addresses_table.jsp";
    }
}
