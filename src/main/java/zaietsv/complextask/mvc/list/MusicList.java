package zaietsv.complextask.mvc.list;

import zaietsv.complextask.mvc.entity.instance.AbstractInstance;
import zaietsv.complextask.mvc.entity.instance.Music;

import java.util.ArrayList;

public class MusicList extends AbstractInstance {

	private ArrayList<Music> musics;

	public MusicList() {

	}

	public MusicList(ArrayList<Music> musics) {
		super();
		this.musics = musics;
	}

	public ArrayList<Music> getMusics() {
		return musics;
	}

	public void setMusics(ArrayList<Music> musics) {
		this.musics = musics;
	}
}
