package zaietsv.complextask.mvc.entity.instance_detail;

import zaietsv.complextask.mvc.entity.instance.Role;
import zaietsv.complextask.mvc.entity.instance.Users;

public class RoleUsers extends AbstractInstanceDetails<Role, Users> {

	/**
	 * Constructs an empty abstract entity
	 */
	public RoleUsers() {
	}

	public RoleUsers(Role instance, Users details) {
		super(instance, details);
	}
}
