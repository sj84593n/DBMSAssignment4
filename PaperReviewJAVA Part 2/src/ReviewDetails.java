import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReviewDetails {
	public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/paperreviews";
    public static final String USER = "root";
    public static final String PASSWORD = "root";
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");	
			System.out.println("Driver's Loaded!\n");
			Connection conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
			System.out.println("Connected to Paper_Review database successfully...!\n");
			Statement stmt = conn.createStatement();
			System.out.println("RESULT OF JOIN IS AS FOLLOWING:\n");
			String Sql = "Select review.Id ,review.MeritScore,review.Recommendation,review.ReadabilityScore,\r\n" + 
					"review.OriginalityScore,review.RelavanceScore,review.EmailAddr\r\n" + 
					"From review JOIN Paper\r\n" + 
					"on review.PaperId = paper.Id\r\n" + 
					"where Recommendation = 'changes'";
			ResultSet rs = stmt.executeQuery(Sql);
			while (rs.next()) {
				int Review_ID = rs.getInt("Id");
				int MeritScore = rs.getInt("MeritScore");
				String Recommendation = rs.getString("Recommendation");
				int ReadabilityScore = rs.getInt("ReadabilityScore");
				int OriginalityScore = rs.getInt("OriginalityScore");
				int RelavanceScore = rs.getInt("RelavanceScore");
				String EmailAddr = rs.getString("EmailAddr");
			
				//Display Values:
				System.out.println("ID: " + Review_ID);
		         System.out.println("MeritScore: " + MeritScore);
		         System.out.println("Recommendation: " + Recommendation);
		         System.out.println("ReadabilityScore: " +ReadabilityScore);
		         System.out.println("OriginalityScore: " +OriginalityScore);
		         System.out.println("RelavanceScore: " +RelavanceScore);
		         System.out.println("EmailAddr: "+EmailAddr+"\n");
				
				
	//System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6));
			}
		} catch(Exception e) {
			e.printStackTrace();
		      }
	      }


	}


