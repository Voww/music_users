package zaietsv.complextask.mvc.authorization;

import zaietsv.complextask.mvc.entity.instance.User;

public interface LoginService {
	
	boolean login(User user);
	
	boolean logout();
}
