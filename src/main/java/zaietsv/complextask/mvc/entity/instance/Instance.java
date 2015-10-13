package zaietsv.complextask.mvc.entity.instance;

import zaietsv.complextask.mvc.entity.Entity;

/**
 * A label interface for Music Users Database entities
 * @author Voww
 *
 */
public interface Instance extends Entity {
	
	/**
	 * Returns an Instance numeric identifier.
	 * @return the id
	 */
	long getId();
	
	/**
	 * Sets an Instance numeric identifier.
	 * @param id the id to set
	 */
	void setId(long id);
	
}
