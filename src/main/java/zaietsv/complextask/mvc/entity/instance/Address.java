package zaietsv.complextask.mvc.entity.instance;

public class Address extends AbstractInstance {

	private int postcode;
	private String city;
	private String street;
	private int house;
	private int flat;
	
	public Address() {
		
	}

	public Address(int postcode, String city, String street, int house, int flat) {
		super();
		this.postcode = postcode;
		this.city = city;
		this.street = street;
		this.house = house;
		this.flat = flat;
	}

	public Address(long id, int postcode, String city, String street, int house, int flat) {
		super(id);
		this.postcode = postcode;
		this.city = city;
		this.street = street;
		this.house = house;
		this.flat = flat;
	}

	/**
	 * @return the postcode
	 */
	public int getPostcode() {
		return postcode;
	}

	/**
	 * @param postcode the postcode to set
	 */
	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the house
	 */
	public int getHouse() {
		return house;
	}

	/**
	 * @param house the house to set
	 */
	public void setHouse(int house) {
		this.house = house;
	}

	/**
	 * @return the flat
	 */
	public int getFlat() {
		return flat;
	}

	/**
	 * @param flat the flat to set
	 */
	public void setFlat(int flat) {
		this.flat = flat;
	}

	@Override
	public String toString() {
		return "Address{" +
				"postcode=" + postcode +
				", city='" + city + '\'' +
				", street='" + street + '\'' +
				", house=" + house +
				", flat=" + flat +
				"} " + super.toString();
	}
}
