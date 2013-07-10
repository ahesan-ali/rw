CREATE DATABASE IF NOT EXISTS rw;
USE rw;


DROP TABLE IF EXISTS Person;
CREATE TABLE Person (
  Id int(11) NOT NULL auto_increment,
  FirstName varchar(45) default NULL,
  LastName varchar(45) default NULL,
  Gender varchar(45) default NULL,
  DOB timestamp NULL default NULL,
  PRIMARY KEY (Id)
);


DROP TABLE IF EXISTS User;
CREATE TABLE User (
  Id int(11) NOT NULL auto_increment,
  Username varchar(45) NOT NULL,
  Password varchar(45) NOT NULL,
  DateRegistered timestamp NOT NULL default CURRENT_TIMESTAMP,
  PRIMARY KEY (Id)
);