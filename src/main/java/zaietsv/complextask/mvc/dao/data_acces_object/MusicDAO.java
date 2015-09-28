package zaietsv.complextask.mvc.dao.data_acces_object;

import zaietsv.complextask.mvc.entity.instance.Music;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MusicDAO extends AbstractDAO<Music> {

	/**
	 * Constructs an empty data access object for `music` table
	 *//*
	public MusicDAO() {
		super();
	}*/

	/**
	 * Constructs a data access object for `music` table using connection parameter
	 * @param connection - an entity of Connection class
	 */
	public MusicDAO(Connection connection) {
		super(connection);
	}

	/* (non-Javadoc)
	 * @see zaietsv.complextask.mvc.dao.data_acces_object.DataAccessObject#insert(zaietsv.complextask.mvc.entity.data_acces_object.InstanceDetail)
	 */
	@Override
	public long insert(Music music) {
		long id = -1;
		String sql = "INSERT INTO music (name, rating) VALUES (?, ?)";
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, music.getName());
			ps.setInt(2, music.getRating());
			
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
	public Music read(long id) {
		String sql = "SELECT * FROM music WHERE id = ?";
		Music music = new Music();
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setLong(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					music.setId(rs.getLong("id"));
					music.setName(rs.getString("name"));
					music.setRating(rs.getInt("rating"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return music;
	}

	@Override
	public long read(Music instance) {
		String sql = "SELECT id FROM music WHERE name = ? AND rating = ?";
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, instance.getName());
			ps.setInt(2, instance.getRating());
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
	 * @see zaietsv.complextask.mvc.dao.data_acces_object.DataAccessObject#update(zaietsv.complextask.mvc.entity.data_acces_object.InstanceDetail)
	 */
	@Override
	public int update(Music music) {
		String sql = "UPDATE music SET `name` = ?, `rating` = ?  WHERE `id` = ?";
		int rows = 0;
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, music.getName());
			ps.setInt(2, music.getRating());
			ps.setLong(3, music.getId());
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
		String sql = " DELETE FROM `music` WHERE id = ? ";
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
	public ArrayList<Music> readAll() {
		String sql = "SELECT * FROM music WHERE 1";
		ArrayList<Music> musics = new ArrayList<>();
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Music music = new Music();
					music.setId(rs.getLong("id"));
					music.setName(rs.getString("name"));
					music.setRating(rs.getInt("rating"));
					musics.add(music);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return musics;
	}
}
