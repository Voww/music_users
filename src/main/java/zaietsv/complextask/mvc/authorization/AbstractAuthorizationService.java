package zaietsv.complextask.mvc.authorization;

import zaietsv.complextask.mvc.connect.MusicUserConnector;
import zaietsv.complextask.mvc.exception.ConnectionException;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;

/**
 * Created by Voww on 17.10.2015.
 */
public abstract class AbstractAuthorizationService implements LoginService, RegisterService, SecurityService {

    protected Connection connection;
    protected HttpServletRequest request;

    public AbstractAuthorizationService() {
    }

    public AbstractAuthorizationService(HttpServletRequest request) {
        try {
            this.request = request;
            connection = new MusicUserConnector().getConnection(request);

        } catch (ConnectionException e) {
            e.printStackTrace();
        }
        ;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
