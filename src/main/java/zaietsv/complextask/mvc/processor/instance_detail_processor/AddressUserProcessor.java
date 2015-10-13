package zaietsv.complextask.mvc.processor.instance_detail_processor;

import zaietsv.complextask.mvc.connect.MusicUserConnector;
import zaietsv.complextask.mvc.dao.data_access_object_detail.AddressUserDAOD;
import zaietsv.complextask.mvc.entity.instance.Address;
import zaietsv.complextask.mvc.entity.instance.User;
import zaietsv.complextask.mvc.entity.instance_detail.AddressUser;
import zaietsv.complextask.mvc.exception.ConnectionException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Voww on 18.09.2015.
 */
public class AddressUserProcessor extends AbstractInstanceDetailProcessor {

    public AddressUserProcessor() {
    }

    public AddressUserProcessor(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ConnectionException {
        super(servletRequest, servletResponse, "address_user", new AddressUserDAOD(new MusicUserConnector().getConnection(servletRequest)), new AddressUser());
    }

    @Override
    public String process() {
        String action = request.getParameter("action");
        action = action == null ? "" : action;
        System.out.println(this.getClass().getName() + " > action = " + action);

        switch (action) {
            case "insert":
                System.out.println("case 'insert':");
                String str_id = request.getParameter("id");

                String login = request.getParameter("login");
                String password = request.getParameter("password");
                String email = request.getParameter("email");
                User newUser = new User(login, password, email);
                System.out.println("newUser=" + newUser);
                if (str_id == null) {
                    int postcode = Integer.parseInt(request.getParameter("postcode"));
                    String city = request.getParameter("city");
                    String street = request.getParameter("street");
                    int house = Integer.parseInt(request.getParameter("house"));
                    int flat = Integer.parseInt(request.getParameter("flat"));
                    Address newAddress = new Address(postcode, city, street, house, flat);
                    System.out.println("newAddress=" + newAddress);
                    AddressUser addressUser = new AddressUser(newAddress, newUser);
                    daod.insert(addressUser);
                    daod.read(addressUser);
                    request.getSession().setAttribute("addressUser", addressUser);
                } else {
                    Long id = Long.parseLong(str_id);
                    daod.insert(id, newUser);
                }
                break;
            case "edit":
                System.out.println("case 'edit':");
                break;
            case "update":
                System.out.println("case 'update':");
                Address updateAddress = null;
                String str_address_id = request.getParameter("address_id");
                if (str_address_id != null) {
                    Long address_id = Long.parseLong(str_address_id);
                    int postcode = Integer.parseInt(request.getParameter("postcode"));
                    String city = request.getParameter("city");
                    String street = request.getParameter("street");
                    int house = Integer.parseInt(request.getParameter("house"));
                    int flat = Integer.parseInt(request.getParameter("flat"));
                    updateAddress = new Address(address_id, postcode, city, street, house, flat);
                }
                User updateUser = null;
                String str_user_id = request.getParameter("user_id");
                if (str_user_id != null) {
                    Long user_id = Long.parseLong(str_user_id);
                    login = request.getParameter("login");
                    password = request.getParameter("password");
                    email = request.getParameter("email");
                    updateUser = new User(user_id, login, password, email);
                }
                System.out.println(daod.update(new AddressUser(updateAddress, updateUser)));
                break;
            case "unlink":
                System.out.println("case unlink:");
                str_id = request.getParameter("id");
                if (str_id != null) {
                    System.out.println(daod.unlink(Long.parseLong(str_id)));
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
                daod.delete(id, user_id);
                break;
            default:
                System.out.println("default:");
                break;
        }
        String str_id = request.getParameter("id");
        if (str_id != null) {
            instanceDetail = daod.read(Long.parseLong(str_id));
            System.out.println("instanceDetail=" + instanceDetail);
            if (instanceDetail == null) {
                request.getSession().removeAttribute("addressUser");
            } else {
                request.getSession().setAttribute("addressUser", instanceDetail);
            }
        }
        return "admin/address_user_table.jsp";
    }
}
