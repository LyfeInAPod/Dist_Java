
CREATE DATABASE cartdatabase;

CREATE TABLE Producttbl (

	   PrductID INTEGER,
	   ProductName VARCHAR(40),
	   stock Integer,
	   ProductPrice INTEGER,
	   Description VARCHAR(200),
	   PRIMARY KEY ( ProductID ));
	   
	   
CREATE TABLE shoppingcart (
	   itemID INTEGER,
	   Items VARCHAR(40));
	   
	