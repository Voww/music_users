package zaietsv.complextask.mvc.install;

import zaietsv.complextask.mvc.connect.MusicUserConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserTableInstaller extends TableInstaller {
	
	private final static String table = "user";
	
	/**
	 * @param connection
	 */
	public UserTableInstaller(Connection connection) {
		super(connection, table);
	}

	@Override
	public boolean install() throws SQLException {
		System.out.println("public static boolean install() throws SQLException { ");
		Boolean success = false;
		String sql = "create table if not exists `" + table + "` (" +
				"id serial primary key," +
				"login varchar (50)," +
				"password varchar (30)," +
				"email varchar (100)," +
				"reg_date date" +
			");";
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			//ps.set(1, dbName);
				int rows = ps.executeUpdate();
			System.out.println("rows=" + rows + ";");
				if (rows == 1 && ps.getWarnings() == null) {
					success = true;
				} else {
					//System.out.println(ps.getWarnings().getErrorCode());
					System.out.println(ps.getWarnings());
				}
		} catch (SQLException e) {
			throw new SQLException("Cannot perform install(). " + table + " Installation is cancelled.", e);
		}
		System.out.println("return " + success + " }");
		return success;
	}
	
	public static void main(String[] args) {
		try {
			MusicUserConnector ct = new MusicUserConnector();
			//ct.connect();
			UserTableInstaller uti = new UserTableInstaller(ct.getConnection());
			uti.install();
			uti.isInstalled();
			uti.unInstall();
			uti.isInstalled();
			//if (!isSchemaInstalled()) {
				//install();
			//}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
