import java.sql.*;

public class work {
	
	public static void main(String[] args) throws SQLException  {
		GUI app = new GUI();
		app.setVisible(true);
		Connect connect = new Connect();
		connect.go();
	}
	
}