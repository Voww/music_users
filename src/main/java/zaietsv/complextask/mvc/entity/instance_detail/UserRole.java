package zaietsv.complextask.mvc.entity.instance_detail;

import zaietsv.complextask.mvc.entity.instance.Role;
import zaietsv.complextask.mvc.entity.instance.User;

public class UserRole extends AbstractInstanceDetail<User, Role> {

	public UserRole() {

	}

	public UserRole(User user, Role role) {
		super(user, role);
	}
}
