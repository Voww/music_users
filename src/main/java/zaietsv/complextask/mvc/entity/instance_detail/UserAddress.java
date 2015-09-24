package zaietsv.complextask.mvc.entity.instance_detail;

import zaietsv.complextask.mvc.entity.instance.Address;
import zaietsv.complextask.mvc.entity.instance.User;

public class UserAddress extends AbstractInstanceDetail<User, Address> {

	public UserAddress() {

	}

	public UserAddress(User user, Address address) {
		super(user, address);
	}
}
