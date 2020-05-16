import java.sql.*;

public class PaperReviewDriver {

    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/paperreviews";
    public static final String USER = "root";
    public static final String PASSWORD = "";

    public static void main(String[] args) {

        try {
            Class.forName(DRIVER);

            Connection conn = DriverManager.getConnection(
                    DATABASE_URL,
                    USER,
                    PASSWORD);

//            Get a submitted paper’s details by the author’s Primary Key. The query should return the
//            following data (columns): Paper.Id, Paper.Title, Paper.Abstract, Author.EmailAddress,
//            Author.FirstName, Author.LastName
            lineSpacing("One");
            getPaperAuthorDetailsByAuthorId("jamespatterson@author.com", conn);

//            Get all reviews for a paper by the paper’s Id, where the paper was recommended to be
//            published. The query should return the following data (columns): All columns from the
//            Review table.
            lineSpacing("Two");
            getReviewDetailsForRecommendedToPublished(conn);

//            Get a count of all papers submitted.
            lineSpacing("Three");
            getCountOfSubmittedPaper(conn);

//            Create a new paper submission. Remember this includes creating new records in both
//            the Author and Paper tables.
            lineSpacing("Four");
            createNewPaperAndAuthorSubmission(conn);

//            Try and Delete the first “Author” row in your Author table by the author’s id. Did you
//            receive an error? If yes, print to the console the error you received. Also note in your
//            message why the query failed. If it didn’t fail, print a message explaining why you were
//            able to delete the row.
            lineSpacing("Five");
            deleteFirstAuthor(conn);


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }


    private static void lineSpacing(String problemNumber) {
        System.out.println();
        System.out.println();
        System.out.println("-------------------Problem Number "+problemNumber+"---------------------------");
        System.out.println();
        System.out.println();
    }

    private static void getPaperAuthorDetailsByAuthorId(String key, Connection conn) {

        try {
            Statement stmt = conn.createStatement();

            String sqlStr = "SELECT " +
                    " paper.Id as id, " +
                    " paper.Title as title, " +
                    " paper.Abstract as abstract, " +
                    " author.EmailAddr as email_address," +
                    " author.FirstName as first_name, " +
                    " author.LastName as last_name" +
                    " FROM " +
                    " paper , author" +
                    " where " +
                    " paper.authorId = author.EmailAddr" +
                    " and author.EmailAddr = '" + key + "'";

            ResultSet rset = stmt.executeQuery(sqlStr);

            while (rset.next()) {
                System.out.println("Paper Id is " + rset.getInt("Id"));
                System.out.println("Paper Title is " + rset.getString("Aitle"));
                System.out.println("Paper Abstract is " + rset.getString("Abstract"));
                System.out.println("Author Email Address is " + rset.getString("EmailAddr"));
                System.out.println("Author First Name is " + rset.getString("FirstName"));
                System.out.println("Author Last Name is " + rset.getString("Last_Name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private static void getReviewDetailsForRecommendedToPublished(Connection conn) {

        try {
            Statement stmt = conn.createStatement();

            String sqlStr = "SELECT " +
                    " paper.Id as id1," +
                    " review.PaperId as paper_id, " +
                    " review.ReviewerId as reviewerid, " +
                    " review.Recommendation as recommendation, " +
                    " review.MeritScore as mscore," +
                    " review.ReadabilityScore as rscore, " +
                    " review.OriginalityScore as oscore," +
                    " review.RelevanceScore as relscore" +
                    " FROM " +
                    " review,paper" +
                    " where " +
                    " paper.Id = review.PaperId" +
                    " and review.Recommendation = 'The paper should be read'";

            ResultSet rset = stmt.executeQuery(sqlStr);

            while (rset.next()) {
                System.out.println("Id is " + rset.getInt("id1"));
                System.out.println("Paper Id is " + rset.getString("paper_id"));
                System.out.println("revierId is " + rset.getString("reviewerid"));
                System.out.println("Recommendation is " + rset.getString("recommendation"));
                System.out.println("Merit Score is " + rset.getInt("mscore"));
                System.out.println("Readability score is " + rset.getInt("rscore"));
                System.out.println("Originality score is " + rset.getInt("oscore"));
                System.out.println("Relevance score is " + rset.getInt("relscore"));
                System.out.println();
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void getCountOfSubmittedPaper(Connection conn) {

        try {
            Statement stmt = conn.createStatement();

            String sqlStr = "SELECT" +
                    " COUNT(*) as count" +
                    " FROM " +
                    " paperreviews.review";
            ResultSet rset = stmt.executeQuery(sqlStr);
            while (rset.next()) {
                System.out.println("Count is " + rset.getInt("count"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private static void createNewPaperAndAuthorSubmission(Connection conn) {

        try {
            Statement ps = conn
                    .createStatement();
            String paperDeleteSql = "delete from Paper where Id=1";
            String authorDeleteSql = "delete from Author where EmailAddr='sj84593n@pace.edu'";
            ps.executeUpdate(paperDeleteSql);
            ps.executeUpdate(authorDeleteSql);


            String authorSql = "insert into Author (EmailAddr, FirstName, LastName)" +
                    "values('danbrown@author.com','Dan','Brown')";


            int i = ps.executeUpdate(authorSql);
            if (i > 0)
                System.out.print("Thank you! You have successfully registered an author...");

            String paperSql = " INSERT INTO PAPER (Id, Title, Abstract, FileName,AuthorId)" +
                    " VALUES (4, 'food', 'benefits of food', 'food.pdf' ,'danbrown@author.com' )";

            System.out.println();
            int j = ps.executeUpdate(paperSql);
            if (j > 0)
                System.out.print("Thank you! You have successfully submitted a paper...");


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private static void deleteFirstAuthor(Connection conn) {

        try {
            Statement ps = conn
                    .createStatement();
            String firstAuthorDeleteSql = "delete from Author where EmailAddr='jamespatterson@author.com'";

            System.out.println();
            int j = ps.executeUpdate(firstAuthorDeleteSql);
            if (j > 0)
                System.out.print("first author successfully deleted...");
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.print("First author cannot be deleted since there is already a paper assigned to this author");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
