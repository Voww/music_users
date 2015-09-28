package zaietsv.complextask.mvc.dao.data_acces_object;

import zaietsv.complextask.mvc.entity.instance.Instance;

import java.util.ArrayList;

/**
 * An interface describes access to a database
 * @author Voww
 *
 * @param <I> a class which implements InstanceDetail interface
 */
public interface DataAccessObject<I extends Instance> {
	
	/**
	 * Inserts a new record into a database
	 * @param instance - an entity of a class which implements InstanceDetail interface
	 * @return - an id for new added entity
	 */
	long insert(I instance);

	/**
	 * Reads an existing record from a database
	 * @param id - the record's key identifier
	 * @return an entity of a class which implements InstanceDetail interface filled with parameters being red
	 */
	I read(long id);

	/**
	 * Reads entity's database id number searching the entity by its essential parameters.
	 * Sets derived fields values into the source entity
	 * @param instance - an entity to be read
	 * @return entity's database id number
	 */
	long read(I instance);

	/**
	 * Updates an existing record in a database
	 * @param instance  - an entity of a class which implements InstanceDetail interface
	 * @return a quantity of affected rows (1 on success 0 on fault)
	 */
	int update(I instance);
	
	/**
	 * Deletes an existing record from a database
	 * @param id - the record's key identifier
	 * @return true on success false otherwise
	 */
	boolean delete(long id);
	
	//boolean exists(long id);
	
	//boolean exists(I entity);
	

	
	/**
	 * Reads all of the existing records from a table or a schema
	 * @return a list of instances of a class which implements InstanceDetail interface filled with parameters being red
	 */
	ArrayList<I> readAll();

}
