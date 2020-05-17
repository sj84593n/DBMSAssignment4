import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class test {
	 	public static final String DRIVER = "com.mysql.jdbc.Driver";
	    public static final String DB_URL = "jdbc:mysql://localhost:3306/paperreviews";
	    public static final String USER = "root";
	    public static final String PASSWORD = "root";
	 
	public static void main(String[] args) {
		try {
		Class.forName("com.mysql.jdbc.Driver");	
		System.out.println("Hey! Its Executed..!");
		Connection conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
		Statement stmt = conn.createStatement();
		String Sql = "select * from Paper";
		ResultSet rs = stmt.executeQuery(Sql);
		while (rs.next()) {
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
		}
	} catch(Exception e) {
		e.printStackTrace();
	      }
      }
}
	