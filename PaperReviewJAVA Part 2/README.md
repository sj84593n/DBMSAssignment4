Steps to run the Paper Review Java Project

Part 2

1. Ensure the latest Paper Review sql scripts are run. 
    - As mentioned in Readme.md of Part 1
     
2. Run PaperReviewJAVAPart 2  which contains all the five methods as mentioned in the assignment
      - DataConnectivity.class - This uses a select query to retrieve the paper and author details.
      - ReviewDetails.class- This retrieves the reviews which are recommended as "The paper should be read"
      - CountPapers.class - This uses a select count(*) to give the count of Submitted paper.
      - InsertDetails.class - This inserts a new author and paper. A delete statement is added to help rerun the method multiple times.
      - DeleteError.class - Tries to delete the first author but fails as there is a foreign key constraint on paper table. Exception is handled and message is displayed accordingly
      - DetailPapers.class - To retrive details of the paper
      -test.class - To check the connection between MySQL database to JDBC 
