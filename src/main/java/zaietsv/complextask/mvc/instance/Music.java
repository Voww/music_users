package zaietsv.complextask.mvc.instance;

public class Music extends AbstractInstance {

	private String name;
	private int rating;
	
	public Music() {
		
	}

	public Music(String name, int rating) {
		super();
		this.name = name;
		this.rating = rating;
	}

	public Music(long id, String name, int rating) {
		super(id);
		this.name = name;
		this.rating = rating;
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

	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}
}
