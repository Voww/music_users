package zaietsv.complextask.mvc.entity.instance;

public abstract class AbstractInstance implements Instance {
	
	/**
	 * an AbstractInstance numeric identifier.
	 */
	protected long id;
	
	/**
	 * Constructs an empty abstract entity
	 */
	public AbstractInstance() {
		this.id = 0;
	}
	
	/**
	 * Constructs an abstract entity using input parameters
	 * @param id - an AbstractInstance numeric identifier.
	 */
	public AbstractInstance(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "AbstractInstance{" +
				"id=" + id +
				'}';
	}
}
