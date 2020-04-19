select * FROM Author;
select * FROM Paper;
select * FROM Reviewer;
select * FROM Review;
select * FROM Topic;
select * FROM Paper left join Author on Paper.EmailAddr = Author.EmailAddr;