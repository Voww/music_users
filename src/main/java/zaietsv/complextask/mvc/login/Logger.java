package zaietsv.complextask.mvc.login;

import java.sql.SQLException;

public interface Logger {
	
	boolean login() throws SQLException;
	
	boolean logout() throws SQLException;

}
