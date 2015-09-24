package zaietsv.complextask.mvc.dao.data_access_instance_detail;

import zaietsv.complextask.mvc.entity.instance_detail.InstanceDetails;

import java.util.ArrayList;

/**
 * An interface describes access to a database
 * @author Voww
 *
 * @param <I> a class which implements InstanceDetail interface
 */
public interface DataAccessInstanceDetails<I extends InstanceDetails> {
	
	/**
	 * Inserts a new record into a database
	 * @param instanceDetails - an entity of a class which implements InstanceDetail interface
	 * @return - an id for new added entity
	 */
	long insert(I instanceDetails);
	
	//boolean insert(ArrayList<InstanceDetail> instances);
	
	/**
	 * Updates an existing record in a database
	 * @param instanceDetails  - an entity of a class which implements InstanceDetail interface
	 * @return a quantity of affected rows (1 on success 0 on fault)
	 */
	int update(I instanceDetails);

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
