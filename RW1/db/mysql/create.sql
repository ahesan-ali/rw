CREATE DATABASE IF NOT EXISTS rw;
USE rw;


DROP TABLE IF EXISTS User;
CREATE TABLE User (
  Id int(11) NOT NULL auto_increment,
  Username varchar(45) NOT NULL,
  Password varchar(45) NOT NULL,
  DateCreated timestamp NOT NULL default '0000-00-00 00:00:00',
  CreatedById int NOT NULL,
  DateModified timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  ModifiedById int NOT NULL,
  PRIMARY KEY (Id),
  FOREIGN KEY (CreatedById) references User(id),
  FOREIGN KEY (ModifiedById) references User(id)
);



DROP TABLE IF EXISTS Person;
CREATE TABLE Person (
  Id int NOT NULL auto_increment,
  FirstName varchar(45) default NULL,
  LastName varchar(45) default NULL,
  Gender varchar(45) default NULL,
  DOB timestamp NULL default NULL,
  DateCreated timestamp NOT NULL default '0000-00-00 00:00:00',
  CreatedById int NOT NULL,
  DateModified timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  ModifiedById int NOT NULL,
  PRIMARY KEY (Id),
  FOREIGN KEY (CreatedById) references User(id),
  FOREIGN KEY (ModifiedById) references User(id)
);


