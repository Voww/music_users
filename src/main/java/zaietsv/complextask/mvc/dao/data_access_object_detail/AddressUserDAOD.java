package zaietsv.complextask.mvc.dao.data_access_object_detail;

import zaietsv.complextask.mvc.dao.data_acces_object.AddressDAO;
import zaietsv.complextask.mvc.dao.data_acces_object.UserDAO;
import zaietsv.complextask.mvc.entity.instance.Address;
import zaietsv.complextask.mvc.entity.instance.User;
import zaietsv.complextask.mvc.entity.instance_detail.AddressUser;

import java.sql.*;

public class AddressUserDAOD extends AbstractDAOD<AddressUser> {

	/**
	 * Constructs an empty data access object for `address` table
	 *//*
	public AddressDAO() {
		super();
	}*/

	/**
	 * Constructs a data access object for `address` table using connection parameter
	 * @param connection - an entity of Connection class
	 */
	public AddressUserDAOD(Connection connection) {
		super(connection);
	}

	/* (non-Javadoc)
	 * @see zaietsv.complextask.mvc.dao.data_acces_object.DataAccessObject#insert(zaietsv.complextask.mvc.entity.data_acces_object.InstanceDetail)
	 */
	@Override
	public int insert(AddressUser addressUser) {
		System.out.println(addressUser);

		AddressDAO adai = new AddressDAO(connection);
		adai.insert(addressUser.getInstance());
		adai.read(addressUser.getInstance());

		UserDAO udai = new UserDAO(connection);
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
	 * @see zaietsv.complextask.mvc.dao.data_acces_object.DataAccessObject#read(long)
	 */
	@Override
	public AddressUser read(long id) {
		String sql = "SELECT * FROM address a LEFT OUTER JOIN user_address ua ON a.id = ua.address_id LEFT OUTER JOIN `user` u ON ua.user_id = u.id HAVING  a.id = ? ";
		AddressUser addressUser = new AddressUser();
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setLong(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					Long aID = rs.getLong("a.id");
					if (aID != 0) {
						Address address = new Address();
						address.setId(rs.getLong("a.id"));
						address.setPostcode(rs.getInt("postcode"));
						address.setCity(rs.getString("city"));
						address.setStreet(rs.getString("street"));
						address.setHouse(rs.getInt("house"));
						address.setFlat(rs.getInt("flat"));
						addressUser.setInstance(address);
					}

					System.out.println("rs.getLong(\"u.id\")=" + rs.getLong("u.id"));
					System.out.println("rs.getString(\"login\")=" + rs.getString("login"));
					System.out.println("rs.getString(\"password\")=" + rs.getString("password"));
					System.out.println("rs.getString(\"email\")=" + rs.getString("email"));
					System.out.println("rs.getDate(\"reg_date\")=" + rs.getDate("reg_date"));

					Long uID = rs.getLong("u.id");
/*					String login = rs.getString("login");
					String password = rs.getString("password");
					String email = rs.getString("email");
					Date reg_date = rs.getDate("reg_date");
*/
					if ( uID != 0) {
						User user = new User();
						user.setId(rs.getLong("u.id"));
						user.setLogin(rs.getString("login"));
						user.setPassword(rs.getString("password"));
						user.setEmail(rs.getString("email"));
						user.setReg_date(rs.getDate("reg_date"));
						addressUser.setDetail(user);
					}
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
	 * @see zaietsv.complextask.mvc.dao.data_acces_object.DataAccessObject#update(zaietsv.complextask.mvc.entity.data_acces_object.InstanceDetail)
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

		AddressDAO adai = new AddressDAO(connection);
		adai.update(addressUser.getInstance());
		UserDAO udai = new UserDAO(connection);
		udai.update(addressUser.getDetail());

		return rows;
	}
	
	/* (non-Javadoc)
	 * @see zaietsv.complextask.mvc.dao.data_acces_object.DataAccessObject#delete(long)
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
	 * @see zaietsv.complextask.mvc.dao.data_acces_object.DataAccessObject#readAll()
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
