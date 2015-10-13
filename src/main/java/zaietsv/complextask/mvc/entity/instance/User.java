package zaietsv.complextask.mvc.entity.instance;

import java.sql.Date;

public class User extends AbstractInstance {

	private String login;
	private String password;
	private String email;
	private Date reg_date;
	
	public User() {
		
	}

	public User(long id, String login, String password, String email, Date reg_date) {
		super(id);
		this.login = login;
		this.password = password;
		this.email = email;
		this.reg_date = reg_date;
	}

	public User(String login, String password, String email) {
		super();
		this.login = login;
		this.password = password;
		this.email = email;
		this.reg_date = new Date(new java.util.Date().getTime());
	}
	
	public User(long id, String login, String password, String email) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.email = email;
	}

	/**
	 * @return the authorization
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the authorization to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the reg_date
	 */
	public Date getReg_date() {
		return reg_date;
	}

	/**
	 * @param reg_date the reg_date to set
	 */
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return "User{" +
				"login='" + login + '\'' +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				", reg_date=" + reg_date +
				"} " + super.toString();
	}
}
