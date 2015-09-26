package zaietsv.complextask.mvc.connect;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public abstract class AbstractConnector implements Connector {

	private static boolean isDriverRegistered = false;

	private Connection connection;
	private String url;
	private String user;
	private String password;

	static {
		System.out.println("static initialization {");
		try {
			System.out.println("try {");
			DriverManager.registerDriver(new Driver());
			System.out.println("try { : 1");
			isDriverRegistered = true;
			System.out.println("try { : isDriverRegistered=" + isDriverRegistered);
		} catch (SQLException e) {
			System.out.println("catch (SQLException e) {");
			e.printStackTrace();
		}
	}

	public static boolean isDriverRegistered() {
		return isDriverRegistered;
	}

	public AbstractConnector(String url, String user, String password) {
		System.out.println("public AbstractConnector(String url, String user, String password) {");
		this.url = url;
		this.user = user;
		this.password = password;
	}

	/**
	 * @return the connection
	 */
	@Override
	public Connection getConnection() throws SQLException {
		System.out.println("public Connection getConnection() throws SQLException {");
		/*if (isDriverRegistered) {
			System.out.println("if (isDriverRegistered) {");
			throw new SQLException("A database driver is not registered! getConnection() failed.");
		}*/
		if (connection == null) {
			System.out.println("if (connection == null) {");
			try {
				System.out.println("try {");
				Properties properties = new Properties();
				properties.put("user", user);
				properties.put("password", password);
				this.connection = DriverManager.getConnection(url, properties);
			} catch (SQLException e) {
				System.out.println("} catch (SQLException e) {");
				e.printStackTrace();
				throw new SQLException("Unable to connect to a database '" + url + "' under user name '" + user + "'! getConnection() failed.", e);
			}
		}
		System.out.println("return connection = " + connection);
		return connection;
	}

	@Override
	public boolean ping() {
		System.out.println("public boolean ping() { ");
		Boolean ping = false;
		try {
			if (connection != null) {
				ping = connection.isValid(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("return " + ping + " }");
		return ping;
	}
	
	@Override
	public void close() throws SQLException {
		System.out.println("public void close() throws SQLException { ");
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Unable to disconnect from a database '" + url + "'! close() failed.", e);
		}
	System.out.println("return void }");
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
