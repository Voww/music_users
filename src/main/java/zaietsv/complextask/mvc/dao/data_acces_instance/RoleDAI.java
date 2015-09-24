package zaietsv.complextask.mvc.dao.data_acces_instance;

import zaietsv.complextask.mvc.entity.instance.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoleDAI extends AbstractDAI<Role> {

	/**
	 * Constructs an empty data access object for `role` table
	 *//*
	public RoleDAI() {
		super();
	}*/

	/**
	 * Constructs a data access object for `role` table using connection parameter
	 * @param connection - an entity of Connection class
	 */
	public RoleDAI(Connection connection) {
		super(connection);
	}

	/* (non-Javadoc)
	 * @see zaietsv.complextask.mvc.dao.data_acces_instance.DataAccessInstance#insert(zaietsv.complextask.mvc.entity.data_acces_instance.InstanceDetail)
	 */
	@Override
	public long insert(Role role) {
		long id = -1;
		String sql = "INSERT INTO role (name) VALUE (?)";
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, role.getName());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	/* (non-Javadoc)
	 * @see zaietsv.complextask.mvc.dao.data_acces_instance.DataAccessInstance#read(long)
	 */
	@Override
	public Role read(long id) {
		String sql = "SELECT * FROM role WHERE id = ?";
		Role role = new Role();
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
		return role;
	}

	@Override
	public long read(Role instance) {
		String sql = "SELECT id FROM role WHERE name = ?";
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, instance.getName());
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					instance.setId(rs.getLong("id"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return instance.getId();
	}
	
	/* (non-Javadoc)
	 * @see zaietsv.complextask.mvc.dao.data_acces_instance.DataAccessInstance#update(zaietsv.complextask.mvc.entity.data_acces_instance.InstanceDetail)
	 */
	@Override
	public int update(Role role) {
		String sql = "UPDATE role SET `name` = ?  WHERE `id` = ?";
		int rows = 0;
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, role.getName());
			ps.setLong(2, role.getId());
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
	 * @see zaietsv.complextask.mvc.dao.data_acces_instance.DataAccessInstance#delete(long)
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
	 * @see zaietsv.complextask.mvc.dao.data_acces_instance.DataAccessInstance#readAll()
	 */
	@Override
	public ArrayList<Role> readAll() {
		String sql = "SELECT * FROM role WHERE 1";
		ArrayList<Role> roles = new ArrayList<>();
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Role role = new Role();
					role.setId(rs.getLong("id"));
					role.setName(rs.getString("name"));
					roles.add(role);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roles;
	}
}
