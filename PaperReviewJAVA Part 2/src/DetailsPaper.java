import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DetailsPaper {
	public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/paperreviews";
    public static final String USER = "root";
    public static final String PASSWORD = "root";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");	
			System.out.println("Driver's Loaded!\n");
			Connection conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
			System.out.println("Connected to Conference_Review database successfully...!\n");
			Statement stmt = conn.createStatement();
			System.out.println("RESULT OF JOIN IS AS FOLLOWING:\n");
			String Sql = "Select paper.Id,paper.Title,Paper.Abstract,Author.EmailAddr,\r\n" + 
					"author.FirstName,author.LastName \r\n" + 
					"FROM paper JOIN author\r\n" + 
					"on paper.EmailAddr = author.EmailAddr";
			ResultSet rs = stmt.executeQuery(Sql);
			while (rs.next()) {
				int P_ID = rs.getInt("Id");
				String Title = rs.getString("Title");
				String Abstract = rs.getString("Abstract");
				String EmailAddr = rs.getString("EmailAddr");
				String FirstName = rs.getString("FirstName");
				String LastName = rs.getString("LastName");
			
				//Display Values:
				System.out.println("ID: " + P_ID);
		         System.out.println("Title: " + Title);
		         System.out.println("Abstract: " + Abstract);
		         System.out.println("EmailAddr: " +EmailAddr);
		         System.out.println("FirstName: " +FirstName);
		         System.out.println("LastName: "+LastName+"\n");
				
				
	//System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6));
			}
		} catch(Exception e) {
			e.printStackTrace();
		      }
	      }

	}


