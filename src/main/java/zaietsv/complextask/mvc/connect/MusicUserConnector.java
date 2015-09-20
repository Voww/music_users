package zaietsv.complextask.mvc.connect;

public class MusicUserConnector extends AbstractConnector {

	public MusicUserConnector() {
		super("jdbc:mysql://localhost:3306/music_users", "tomcat", "tacmot");
	}
}
