package zaietsv.complextask.mvc.factory;

import zaietsv.complextask.mvc.processor.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class ProcessorFactory extends AbstractProcessorFactory {

    public Processor getProcessor(HttpServletRequest request, HttpServletResponse response) {
        Processor processor = null;

        String table = request.getParameter("table");
        table = table == null ? "" : table;

        try {
            switch (table) {
                case "user":
                    processor = new UsersProcessor(request, response);
                    break;
                case "role":
                    processor = new RolesProcessor(request,response);
                    break;
                case "role_users":
                    processor = new RoleUsersProcessor(request,response);
                    break;
                case "address":
                    processor = new AddressesProcessor(request,response);
                    break;
                case "address_user":
                    processor = new AddressUserProcessor(request,response);
                    break;
                case "music":
                    processor = new MusicsProcessor(request,response);
                    break;
                default:
                    processor = new DefaultProcessor(request,response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return processor;
    }
}
