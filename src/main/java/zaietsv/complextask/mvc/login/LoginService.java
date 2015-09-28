package zaietsv.complextask.mvc.login;

import java.sql.SQLException;

public interface LoginService {
	
	boolean login() throws SQLException;
	
	boolean logout() throws SQLException;

}
