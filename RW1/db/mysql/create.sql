CREATE DATABASE IF NOT EXISTS rw;
USE rw;


DROP TABLE IF EXISTS User;
CREATE TABLE User (
    Id int UNSIGNED NOT NULL auto_increment,
    Username varchar(45) NOT NULL,
    Password varchar(45) NOT NULL,
    DateCreated timestamp NOT NULL default '0000-00-00 00:00:00',
    CreatedByUserId int UNSIGNED NOT NULL,
    DateModified timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
    ModifiedByUserId int UNSIGNED NOT NULL,
  
    PRIMARY KEY (Id),
  
    CONSTRAINT FK_User_CreatedByUserId FOREIGN KEY (CreatedByUserId) REFERENCES User(Id),
    CONSTRAINT FK_User_ModifiedByUserId FOREIGN KEY (ModifiedByUserId) REFERENCES User(Id)
);


CREATE TABLE UserRole (
  Id INT UNSIGNED NOT NULL auto_increment,
  UserId INT UNSIGNED NOT NULL,
  Authority VARCHAR(45) NOT NULL,
  DateCreated timestamp NOT NULL default '0000-00-00 00:00:00',
  CreatedByUserId int UNSIGNED NOT NULL,
  DateModified timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  ModifiedByUserId int UNSIGNED NOT NULL,
  
  PRIMARY KEY (Id),
  
  CONSTRAINT FK_UserRole_UserId FOREIGN KEY (UserId) REFERENCES User(Id),
  CONSTRAINT FK_UserRole_CreatedByUserId FOREIGN KEY (CreatedByUserId) REFERENCES User(Id),
  CONSTRAINT FK_UserRole_ModifiedByUserId FOREIGN KEY (ModifiedByUserId) REFERENCES User(Id)
);



DROP TABLE IF EXISTS Person;
CREATE TABLE Person (
  Id int UNSIGNED  NOT NULL auto_increment,
  FirstName varchar(45) default NULL,
  LastName varchar(45) default NULL,
  Gender enum('MALE', 'FEMALE') default NULL,
  DOB timestamp NULL default NULL,
  DateCreated timestamp NOT NULL default '0000-00-00 00:00:00',
  CreatedByUserId int UNSIGNED NOT NULL,
  DateModified timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  ModifiedByUserId int UNSIGNED NOT NULL,
  
  PRIMARY KEY (Id),
  
    CONSTRAINT FK_Person_CreatedByUserId FOREIGN KEY (CreatedByUserId) REFERENCES User(Id),
    CONSTRAINT FK_Person_ModifiedByUserId FOREIGN KEY (ModifiedByUserId) REFERENCES User(Id)
);


