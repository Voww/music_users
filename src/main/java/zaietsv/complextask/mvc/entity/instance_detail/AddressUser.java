package zaietsv.complextask.mvc.entity.instance_detail;

import zaietsv.complextask.mvc.entity.instance.Address;
import zaietsv.complextask.mvc.entity.instance.User;

public class AddressUser extends AbstractInstanceDetail<Address, User> {

	public AddressUser() {

	}

	public AddressUser(Address instance, User detail) {
		super(instance, detail);
	}
}
