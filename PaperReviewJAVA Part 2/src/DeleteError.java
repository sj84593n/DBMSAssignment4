
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DeleteError {

	public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/paperreviews";
    public static final String USER = "root";
    public static final String PASSWORD = "root";

	public static void main(String[] args) {
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);

			Problem("One");
			DetailsByAuthorId(conn);

			Problem("Two");
			ReviewDetailsForPublished(conn);

			Problem("Three");
			CountOfPaper(conn);

			Problem("Four");
			InsertNewRecords(conn);

			Problem("Five");
			deleteRecord(conn);


		}catch (Exception e) {
			e.printStackTrace();
		}
	}



	private static void Problem(String ProblemNo) {
		System.out.println("\n********************Problem Number "+ProblemNo+"***********************\n");

	}

	private static void DetailsByAuthorId(Connection conn) {

		try {

			Statement stmt = conn.createStatement();
			System.out.println("RESULT OF JOIN IS AS FOLLOWING:\n");

			String Sql = "Select paper.Id,paper.Title,paper.Abstract,author.EmailAddr,\r\n" +
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
				System.out.println("EmailAddress: " +EmailAddr);
				System.out.println("FirstName: " +FirstName);
				System.out.println("LastName: "+LastName+"\n");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void ReviewDetailsForPublished(Connection conn) {

		try {

			Statement stmt = conn.createStatement();
			System.out.println("These are details of Papers that got PUBLISHED:\n");

			String Sql = "Select review.Id ,review.MeritScore,review.Recommendation,review.ReadabilityScore,\r\n" +
					"review.OriginalityScore,review.RelavanceScore,review.EmailAddr\r\n" +
					"From review JOIN paper\r\n" +
					"on review.Id = paper.Id\r\n" +
					"where Recommendation = 'changes'";

			ResultSet rs = stmt.executeQuery(Sql);

			while (rs.next()) {
				int Id = rs.getInt("Id");
				int MeritScore = rs.getInt("MeritScore");
				String Recommendation = rs.getString("Recommendation");
				int ReadabilityScore = rs.getInt("ReadabilityScore");
				int OriginalityScore = rs.getInt("OriginalityScore");
				int RelavanceScore = rs.getInt("RelavanceScore");
				String EmailAddr = rs.getString("EmailAddr");

				//Display Values:
				System.out.println("ID: " + Id);
				System.out.println("MeritScore: " + MeritScore);
				System.out.println("Recommendation: " + Recommendation);
				System.out.println("ReadabilityScore: " +ReadabilityScore);
				System.out.println("OriginalityScore: " +OriginalityScore);
				System.out.println("RelavanceScore: " +RelavanceScore);
				System.out.println("R_Email: "+EmailAddr+"\n");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	private static void CountOfPaper(Connection conn) {

		try {
			Statement stmt = conn.createStatement();
			System.out.println("The total number of papers that got submitted:\n");

			String Sql = "Select COUNT(Id) AS TOTAL_NO_OF_PAPERS from Paper;";
			ResultSet rs = stmt.executeQuery(Sql);
			while (rs.next()) {
				int TOTAL_NO_OF_PAPERS = rs.getInt("TOTAL_NO_OF_PAPERS");

				//Display Values:
				System.out.println("Total Number of Papers: " + TOTAL_NO_OF_PAPERS);

			}

		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	private static void InsertNewRecords(Connection conn) {
		try {
			Statement stmt = conn.createStatement();
			System.out.println("FOLLOWING HAS TAKEN PLACE IN YOUR DATABASE:\n");
			String AuthorRecord = "Insert into author(EmailAddr,FirstName,LastName)\r\n" +
					"values ('Varshita@gmail.com','Varshita','Dave')";
			//stmt.executeUpdate(AuthorRecord);
			String PaperRecord = "Insert into paper(Id,Title,Abstract,FileName,EmailAddr)\r\n" +
					"values(12,'Virus','How can prevented','B4','Varshita@gmail.com')";

			int i = stmt.executeUpdate(AuthorRecord);
			if (i > 0)
				System.out.println("Hey! Your record has been successfully recorded in author!\n");


			int k = stmt.executeUpdate(PaperRecord);
			if (k > 0)
				System.out.println("Hey! Your record has been successfully recorded in Paper!\n");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void deleteRecord(Connection conn) throws SQLException {
		try {
			Statement stmt = conn.createStatement();
			String Sql = "Delete from author where EmailAddr = 'Varshita@gmail.com'";
			stmt.executeQuery(Sql);

		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("The DELETE statement conflicted with the REFERENCE constraint. The conflict occurred in table dbo.Paper and column 'Author_Email'.\r\n" +
					"The query failed because there is a record in Paper table. You cannot delete record from Parent table if it exists in child table.");
		}

	}
}





