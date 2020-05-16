Steps to run the Paper Review Java Project

Part 2

1. Ensure the latest Paper Review sql scripts are run. 
    - As mentioned in Readme.md of Part 1
    - Paper Table has been updated to add Author's Primary key as a foreign Key in Paper table.
2. Run PaperReviewDriver java class which contains all the five methods as mentioned in the assignment
      - getPaperAuthorDetailsByAuthorId - This uses a select query to retrieve the paper and author details.
      - getReviewDetailsForRecommendedToPublished - This retrieves the reviews which are recommended as "The paper should be read"
      - getCountOfSubmittedPaper - This uses a select count(*) to give the count of Submitted paper.
      - createNewPaperAndAuthorSubmission - This inserts a new author and paper. A delete statement is added to help rerun the method multiple times.
      - deleteFirstAuthor - Tries to delete the first author but fails as there is a foreign key constraint on paper table. Exception is handled and message is displayed accordingly