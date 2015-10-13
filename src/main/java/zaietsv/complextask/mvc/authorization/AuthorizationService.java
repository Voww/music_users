package zaietsv.complextask.mvc.authorization;

import java.sql.SQLException;

public interface AuthorizationService {
	
	boolean login() throws SQLException;
	
	boolean logout() throws SQLException;

}
