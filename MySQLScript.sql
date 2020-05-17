Create database PaperReviews;
Use PaperReviews;
create table Author(
EmailAddr varchar(20), 
FirstName varchar(10), 
LastName varchar(10), PRIMARY KEY(EmailAddr));

create table Paper(
Id INT, 
EmailAddr varchar(20) NOT NULL, 
Title varchar(20) NOT NULL, 
Abstract varchar(40) NOT NULL, 
FileName varchar(15) NOT NULL, 
PRIMARY KEY(Id), 
foreign key(EmailAddr) references Author(EmailAddr));

create table Reviewer(
EmailAddr varchar(20) NOT NULL,
FirstName varchar(10) NOT NULL,
AuthorFeedback varchar(50),
LastName varchar(10) NOT NULL,
CommiteeFeedback varchar(50),
PhoneNum varchar(10) NOT NULL,
Affilation varchar(20),
Id INT NOT NULL,
PRIMARY KEY(EmailAddr),
foreign key(Id) references Paper(Id));

create table Topic(
EmailAddr varchar(20) NOT NULL,
Id INT NOT NULL,
TopicName varchar(15) NOT NULL,
PRIMARY KEY(Id),
foreign key(EmailAddr) references Reviewer(EmailAddr)
);


create table Review(
EmailAddr varchar(20) NOT NULL,
Recommendation varchar(10) ,
Id INT,
MeritScore INT NOT NULL,
PaperId INT NOT NULL,
ReadabilityScore INT NOT NULL,
RevieweId INT NOT NULL,
OriginalityScore INT NOT NULL,
RelavanceScore INT NOT NULL,
PRIMARY KEY(ID),
foreign key(EmailAddr) references Reviewer(EmailAddr)
);