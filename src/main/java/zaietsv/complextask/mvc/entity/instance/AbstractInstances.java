package zaietsv.complextask.mvc.entity.instance;

import java.util.ArrayList;

/**
 * Holds a list of instances of AbstractInstance subclass
 * @param <I> - an entity of AbstractInstance subclass
 */
public class AbstractInstances<I extends AbstractInstance> implements Instances<I> {

	/**
	 * A list of instances
	 */
	protected ArrayList<I> instances;

	/**
	 * An empty class constructor
	 */
	public AbstractInstances() {
		instances = new ArrayList<>();
	}

	/**
	 * A class constructor
	 * @param instances - a list of instances to be set
	 */
	public AbstractInstances(ArrayList<I> instances) {
		this.instances = instances;
	}

	/**
	 * Returns a list of instances
	 * @return - a list of instances
	 */
	@Override
	public ArrayList<I> getInstances() {
		return instances;
	}

	/**
	 * Sets a list of instances
	 * @param instances - a list of instances to be set
	 */
	@Override
	public void setInstances(ArrayList<I> instances) {
		this.instances = instances;
	}
}
