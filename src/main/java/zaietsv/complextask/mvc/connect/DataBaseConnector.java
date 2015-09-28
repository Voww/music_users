package zaietsv.complextask.mvc.connect;

public class DataBaseConnector extends AbstractConnector {

	public DataBaseConnector() {

		super("jdbc:mysql://localhost:3306", "tomcat", "tacmot");
	}
}
