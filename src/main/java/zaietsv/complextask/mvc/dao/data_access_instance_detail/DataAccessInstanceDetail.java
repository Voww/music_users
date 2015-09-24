package zaietsv.complextask.mvc.dao.data_access_instance_detail;

import zaietsv.complextask.mvc.entity.instance_detail.InstanceDetail;

import java.util.ArrayList;

/**
 * An interface describes access to a database
 * @author Voww
 *
 * @param <I> a class which implements InstanceDetail interface
 */
public interface DataAccessInstanceDetail<I extends InstanceDetail> {
	
	/**
	 * Inserts a new record into a database
	 * @param instanceDetail - an entity of a class which implements InstanceDetail interface
	 * @return - affected rows count
	 */
	int insert(I instanceDetail);
	
	//boolean insert(ArrayList<InstanceDetail> instances);
	
	/**
	 * Updates an existing record in a database
	 * @param instanceDetail  - an entity of a class which implements InstanceDetail interface
	 * @return a quantity of affected rows (1 on success 0 on fault)
	 */
	int update(I instanceDetail);

	/**
	 *
	 * @param id - an Instance's database id number
	 * @return true on success false otherwise
	 */
	boolean delete(long id);
	
	/**
	 * Reads an existing record from a database
	 * @param id - the record's key identifier
	 * @return an entity of a class which implements InstanceDetail interface filled with parameters being red
	 */
	I read(long id);
	
	/**
	 * Reads all of the existing records from a table or a schema
	 * @return a list of instances of a class which implements InstanceDetail interface filled with parameters being red
	 */
	ArrayList<I> readAll();

}
