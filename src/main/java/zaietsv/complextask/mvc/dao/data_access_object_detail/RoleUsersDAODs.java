package zaietsv.complextask.mvc.dao.data_access_object_detail;

import zaietsv.complextask.mvc.entity.instance.Role;
import zaietsv.complextask.mvc.entity.instance.Users;
import zaietsv.complextask.mvc.entity.instance_detail.RoleUsers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoleUsersDAODs extends AbstractDAODs<RoleUsers> {

	/**
	 * Constructs an empty data access object for `role` table
	 *//*
	public RoleDAO() {
		super();
	}*/

	/**
	 * Constructs a data access object for `role` table using connection parameter
	 * @param connection - an entity of Connection class
	 */
	public RoleUsersDAODs(Connection connection) {
		super(connection);
	}

	/* (non-Javadoc)
	 * @see zaietsv.complextask.mvc.dao.data_acces_object.DataAccessObject#insert(zaietsv.complextask.mvc.entity.data_acces_object.InstanceDetail)
	 */
	@Override
	public long insert(RoleUsers roleUsers) {
		long id = -1;
		String sql = "INSERT INTO role (name) VALUE (?)";
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, roleUsers.getInstance().getName());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	/* (non-Javadoc)
	 * @see zaietsv.complextask.mvc.dao.data_acces_object.DataAccessObject#read(long)
	 */
	@Override
	public RoleUsers read(long id) {
		String sql = "SELECT * FROM role WHERE id = ?";
		Role role = new Role();
		Users users = new Users();
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setLong(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					role.setId(rs.getLong("id"));
					role.setName(rs.getString("name"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new RoleUsers(role, users);
	}
	
	/* (non-Javadoc)
	 * @see zaietsv.complextask.mvc.dao.data_acces_object.DataAccessObject#update(zaietsv.complextask.mvc.entity.data_acces_object.InstanceDetail)
	 */
	@Override
	public int update(RoleUsers roleUsers) {
		String sql = "UPDATE role SET `name` = ?  WHERE `id` = ?";
		int rows = 0;
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, roleUsers.getInstance().getName());
			ps.setLong(2, roleUsers.getInstance().getId());
			try {
				rows = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}

	/* (non-Javadoc)
	 * @see zaietsv.complextask.mvc.dao.data_acces_object.DataAccessObject#delete(long)
	 */
	@Override
	public boolean delete(long id) {
		String sql = " DELETE FROM `role` WHERE id = ? ";
		boolean res = false;
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setLong(1, id);
			res = ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	/* (non-Javadoc)
	 * @see zaietsv.complextask.mvc.dao.data_acces_object.DataAccessObject#readAll()
	 */
	@Override
	public ArrayList<RoleUsers> readAll() {
		String sql = "SELECT * FROM role WHERE 1";
		ArrayList<RoleUsers> roleUsersList = new ArrayList<>();
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					RoleUsers roleUsers  = new RoleUsers();
					roleUsers.getInstance().setId(rs.getLong("id"));
					roleUsers.getInstance().setName(rs.getString("name"));
					roleUsersList.add(roleUsers);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roleUsersList;
	}
}
