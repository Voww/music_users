package zaietsv.complextask.mvc.connect;

import java.sql.Connection;
import java.sql.SQLException;

public interface Connector extends AutoCloseable {

	/**
	 * Connects to a database
	 * @return a database connection
	 * @throws SQLException - if a database access error occurs
	 */
	Connection getConnection() throws SQLException;

	/**
	 * Validates a database connection
	 * @return true on success false on fault
	 */
	boolean ping();
}
