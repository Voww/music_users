package zaietsv.complextask.mvc.entity.instance;

import java.util.ArrayList;

/**
 * A label interface for Music Users Database entities
 * @author Voww
 *
 */
public interface Instances<I extends Instance> {

	/**
	 * Returns a list of instances which are inherits Instance interface
	 * @return ArrayList<I> - a list of instances to be returned
	 */
	ArrayList<I> getInstances();

	/**
	 *
	 * @param instances - a list of instances to be set
	 */
	void setInstances(ArrayList<I> instances);
	
}
