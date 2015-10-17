package zaietsv.complextask.mvc.authorization;

import zaietsv.complextask.mvc.entity.instance.User;

public interface RegisterService {
	
	boolean register(User user);
	
	boolean unRegister(Long userId);

}
