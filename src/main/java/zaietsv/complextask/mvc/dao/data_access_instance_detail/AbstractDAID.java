package zaietsv.complextask.mvc.dao.data_access_instance_detail;

import zaietsv.complextask.mvc.entity.instance_detail.AbstractInstanceDetail;

import java.sql.Connection;

public abstract class AbstractDAID<I extends AbstractInstanceDetail> implements DataAccessInstanceDetail<I> {

	protected Connection connection;
	
	/**
	 * Constructs an empty data access object
	 *//*
	public AbstractDAI() {
		
	}*/

	/**
	 * Constructs a data access object using connection parameter
	 * @param connection - an entity of Connection class
	 */
	public AbstractDAID(Connection connection) {
		this.connection = connection;
	}

	/**
	 * Returns a connection
	 * @return the connection
	 */
	public Connection getConnection() {
		return connection;
	}

	/**
	 * Sets a connection
	 * @param connection the connection to set
	 */
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}
