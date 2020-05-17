import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CountPapers {
	public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/paperreviews";
    public static final String USER = "root";
    public static final String PASSWORD = "";
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");	
			System.out.println("Driver's Loaded!\n");
			Connection conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
			System.out.println("Connected to Conference_Review database successfully...!\n");
			Statement stmt = conn.createStatement();
			System.out.println("RESULT OF JOIN IS AS FOLLOWING:\n");
			String Sql = "Select COUNT(Id) AS TOTAL_NO_OF_PAPERS from Paper;";
			ResultSet rs = stmt.executeQuery(Sql);
			while (rs.next()) {
				int TOTAL_NO_OF_PAPERS = rs.getInt("TOTAL_NO_OF_PAPERS");
				
		//Display Values:
				System.out.println("Total Number of Papers: " + TOTAL_NO_OF_PAPERS);
		       
				
	//System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6));
			}
		} catch(Exception e) {
			e.printStackTrace();
		      }
	      }
	}


