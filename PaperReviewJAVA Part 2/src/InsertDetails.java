import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.Statement;


public class InsertDetails {
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
			String AuthorRecord = "Insert into author(EmailAddr,FirstName,LastName)\r\n" + 
					"values ('Harshaal@gmail.com','Harshaal','Patil')";
			//stmt.executeUpdate(AuthorRecord);
			String PaperRecord = "Insert into Paper(Id,Title,Abstract,FileName)\r\n" + 
					"values(09,'COVID','Pandemic of many life!,'C2')";
		    //stmt.executeUpdate(PaperRecord);
		   // System.out.println("Records inserted Successfully..!");
		    int i = stmt.executeUpdate(AuthorRecord);
            if (i > 0)
                System.out.println("Hey! Your record has been successfully recorded in author!\n");

		
	    int k = stmt.executeUpdate(PaperRecord);
        if (k > 0)
            System.out.println("Hey! Your record has been successfully recorded in Paper!\n");
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("OOPS..!Something went wrong. Please check!");
		      }
	      }
	
}


