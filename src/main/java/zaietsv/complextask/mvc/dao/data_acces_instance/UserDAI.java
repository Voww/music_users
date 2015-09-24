package zaietsv.complextask.mvc.dao.data_acces_instance;

import zaietsv.complextask.mvc.entity.instance.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAI extends AbstractDAI<User> {
	
	/**
	 * Constructs an empty data access object for `user` table
	 *//*
	public UserDAI() {
		super();
	}*/

	/**
	 * Constructs a data access object for `user` table using connection parameter
	 * @param connection - an entity of Connection class
	 */
	public UserDAI(Connection connection) {
		super(connection);
	}

	/* (non-Javadoc)
	 * @see zaietsv.complextask.mvc.dao.data_acces_instance.DataAccessInstance#insert(zaietsv.complextask.mvc.entity.data_acces_instance.InstanceDetail)
	 */
	@Override
	public long insert(User user) {
		long id = -1;
		String sql = "INSERT INTO user (login, password, email, reg_date) VALUES (?, ?, ?, ?)";
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, user.getLogin());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setDate(4, user.getReg_date());
			
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
	public User read(long id) {
		String sql = "SELECT * FROM user WHERE id = ?";
		User user = new User();
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setLong(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					user.setId(rs.getLong("id"));
					user.setLogin(rs.getString("login"));
					user.setPassword(rs.getString("password"));
					user.setEmail(rs.getString("email"));
					user.setReg_date(rs.getDate("reg_date"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}



	/**
	 * Reads entity's database id number searching the entity by its essential parameters.
	 * Sets derived fields values into the source entity
	 *
	 * @param instance - an entity to be read
	 * @return entity's database id number
	 */
	@Override
	public long read(User instance) {
		String sql = "SELECT `id` FROM `user` WHERE `login` = ? AND `password` = ? AND `email` = ? AND `reg_date` = ?";
		//String sql = "SELECT `id` FROM `user` WHERE `login` = ? AND `password` = ? AND `email` = ?";
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, instance.getLogin());
			ps.setString(2, instance.getPassword());
			ps.setString(3, instance.getEmail());
			ps.setDate(4, instance.getReg_date());

			System.out.println("ps=" + ps);

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
	public int update(User user) {
		String sql = "UPDATE user SET `login` = ?, `password` = ?, `email` = ?  WHERE `id` = ?";
		int rows = 0;
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, user.getLogin());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setLong(4, user.getId());
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
		String sql = " DELETE FROM `user` WHERE id = ? ";
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
	public ArrayList<User> readAll() {
		String sql = "SELECT * FROM user WHERE 1";
		ArrayList<User> users = new ArrayList<>();
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					User user = new User();
					user.setId(rs.getLong("id"));
					user.setLogin(rs.getString("login"));
					user.setPassword(rs.getString("password"));
					user.setEmail(rs.getString("email"));
					user.setReg_date(rs.getDate("reg_date"));
					users.add(user);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
}
