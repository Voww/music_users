package zaietsv.complextask.mvc.instance;

public class Role extends AbstractInstance {

	private String name;
	
	public Role() {
		
	}

	public Role(String name) {
		super();
		this.name = name;
	}

	public Role(long id, String name) {
		super(id);
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


}
