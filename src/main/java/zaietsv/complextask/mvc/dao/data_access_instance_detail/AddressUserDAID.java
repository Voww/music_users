package zaietsv.complextask.mvc.dao.data_access_instance_detail;

import zaietsv.complextask.mvc.dao.data_acces_instance.AddressDAI;
import zaietsv.complextask.mvc.dao.data_acces_instance.UserDAI;
import zaietsv.complextask.mvc.entity.instance.Address;
import zaietsv.complextask.mvc.entity.instance.User;
import zaietsv.complextask.mvc.entity.instance_detail.AddressUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressUserDAID extends AbstractDAID<AddressUser> {

	/**
	 * Constructs an empty data access object for `address` table
	 *//*
	public AddressDAI() {
		super();
	}*/

	/**
	 * Constructs a data access object for `address` table using connection parameter
	 * @param connection - an entity of Connection class
	 */
	public AddressUserDAID(Connection connection) {
		super(connection);
	}

	/* (non-Javadoc)
	 * @see zaietsv.complextask.mvc.dao.data_acces_instance.DataAccessInstance#insert(zaietsv.complextask.mvc.entity.data_acces_instance.InstanceDetail)
	 */
	@Override
	public int insert(AddressUser addressUser) {
		System.out.println(addressUser);

		AddressDAI adai = new AddressDAI(connection);
		adai.insert(addressUser.getInstance());
		adai.read(addressUser.getInstance());

		UserDAI udai = new UserDAI(connection);
		udai.insert(addressUser.getDetail());
		udai.read(addressUser.getDetail());

		System.out.println(addressUser);

		int rows = 0;
		String sql = "INSERT INTO user_address (address_id, user_id)  VALUES (?, ?)";
		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setLong(1, addressUser.getInstance().getId());
			ps.setLong(2, addressUser.getDetail().getId());
			rows = ps.executeUpdate();
			System.out.println("success");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}

	/* (non-Javadoc)
	 * @see zaietsv.complextask.mvc.dao.data_acces_instance.DataAccessInstance#read(long)
	 */
	@Override
	public AddressUser read(long id) {
		String sql = "SELECT * FROM address a LEFT OUTER JOIN user_address ua ON a.id = ua.address_id LEFT OUTER JOIN `user` u ON ua.user_id = u.id HAVING  a.id = ? ";
		AddressUser addressUser = new AddressUser();
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setLong(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					Address address = new Address();
					address.setId(rs.getLong("a.id"));
					address.setPostcode(rs.getInt("postcode"));
					address.setCity(rs.getString("city"));
					address.setStreet(rs.getString("street"));
					address.setHouse(rs.getInt("house"));
					address.setFlat(rs.getInt("flat"));

					User user = new User();
					user.setId(rs.getLong("u.id"));
					user.setLogin(rs.getString("login"));
					user.setPassword(rs.getString("password"));
					user.setEmail(rs.getString("email"));
					user.setReg_date(rs.getDate("reg_date"));

					addressUser.setInstance(address);
					addressUser.setDetail(user);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("addressUser=" + addressUser);
		return addressUser;
	}
	

	/* (non-Javadoc)
	 * @see zaietsv.complextask.mvc.dao.data_acces_instance.DataAccessInstance#update(zaietsv.complextask.mvc.entity.data_acces_instance.InstanceDetail)
	 */
	@Override
	public int update(AddressUser addressUser) {
		//String sql = "UPDATE user_address SET user_id = ?, `city` = ?, `street` = ?, `house` = ?, `flat` = ?  WHERE `id` = ?";
		int rows = 0;
		/*try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setInt(1, addressUser.getInstance().getPostcode());
			ps.setString(2, addressUser.getInstance().getCity());
			ps.setString(3, addressUser.getInstance().getStreet());
			ps.setInt(4, addressUser.getInstance().getHouse());
			ps.setInt(5, addressUser.getInstance().getFlat());
			ps.setLong(6, addressUser.getInstance().getId());
			try {
				rows = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}*/

		AddressDAI adai = new AddressDAI(connection);
		adai.update(addressUser.getInstance());
		UserDAI udai = new UserDAI(connection);
		udai.update(addressUser.getDetail());

		return rows;
	}
	
	/* (non-Javadoc)
	 * @see zaietsv.complextask.mvc.dao.data_acces_instance.DataAccessInstance#delete(long)
	 */
	@Override
	public boolean delete(long id) {
		String sql = " DELETE FROM `address`, `user_address`, `user` WHERE address.id = user_address.address_id AND user.id = user_address.user_id AND  address.id = ? ";
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
	 *//*
	@Override
	public ArrayList<AddressUser> readAll() {
		String sql = "SELECT * FROM address WHERE 1";
		ArrayList<AddressUser> addressUserList = new ArrayList<>();
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					AddressUser addressUser = new AddressUser();
					addressUser.getInstance().setId(rs.getLong("id"));
					addressUser.getInstance().setPostcode(rs.getInt("postcode"));
					addressUser.getInstance().setCity(rs.getString("city"));
					addressUser.getInstance().setStreet(rs.getString("street"));
					addressUser.getInstance().setHouse(rs.getInt("house"));
					addressUser.getInstance().setFlat(rs.getInt("flat"));
					addressUserList.add(addressUser);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return addressUserList;
	}*/
}
