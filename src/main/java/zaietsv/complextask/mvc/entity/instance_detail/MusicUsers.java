package zaietsv.complextask.mvc.entity.instance_detail;

import zaietsv.complextask.mvc.entity.instance.Music;
import zaietsv.complextask.mvc.entity.instance.Users;

public class MusicUsers extends AbstractInstanceDetails<Music, Users> {

	public MusicUsers() {
	}

	public MusicUsers(Music instance, Users details) {
		super(instance, details);
	}
}
