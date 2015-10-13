package zaietsv.complextask.mvc.connect;

import com.mysql.jdbc.Driver;
import zaietsv.complextask.mvc.exception.ConnectionException;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

public abstract class AbstractConnector implements Connector {

	private static boolean isDriverRegistered = false;

	private Connection connection;
	private String url;
	private String user;
	private String password;

	static {
		try {
			DriverManager.registerDriver(new Driver());
			isDriverRegistered = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static boolean isDriverRegistered() {
		return isDriverRegistered;
	}

	public AbstractConnector(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
	}

	public AbstractConnector(String propertyFileName) {
		ResourceBundle resourceBundle = ResourceBundle.getBundle(propertyFileName);
		this.url = resourceBundle.getString("url");
		this.user = resourceBundle.getString("user");
		this.password = resourceBundle.getString("password");
	}
	/**
	 * @return the connection
	 */
	@Override
	public Connection getConnection(HttpServletRequest request) throws ConnectionException {
		/*if (isDriverRegistered()) {
			throw new ConnectionException("A database driver is not registered! getConnection() failed.");
		}*/

		connection = (Connection)request.getSession().getAttribute("connection");
		if (connection == null) {
			try {
				Properties properties = new Properties();
				properties.put("user", user);
				properties.put("password", password);
				this.connection = DriverManager.getConnection(url, properties);
				request.getSession().setAttribute("connection", connection);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ConnectionException("Unable to connect to a database '" + url + "' under user name '" + user + "'! getConnection() failed.", e);
			}
		}
		return connection;
	}

	@Override
	public boolean ping() {
		Boolean ping = false;
		try {
			if (connection != null) {
				ping = connection.isValid(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ping;
	}
	
	@Override
	public void close() throws ConnectionException {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ConnectionException("Unable to disconnect from a database '" + url + "'! close() failed.", e);
		}
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
}
