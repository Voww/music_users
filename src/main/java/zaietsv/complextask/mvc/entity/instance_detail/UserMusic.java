package zaietsv.complextask.mvc.entity.instance_detail;

import zaietsv.complextask.mvc.list.MusicList;
import zaietsv.complextask.mvc.entity.instance.User;

public class UserMusic extends AbstractInstanceDetail<User, MusicList> {

	public UserMusic() {

	}

	public UserMusic(User user, MusicList musics) {
		super(user, musics);
	}
}
