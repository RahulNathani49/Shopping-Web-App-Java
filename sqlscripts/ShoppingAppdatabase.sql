CREATE TABLE shoppingapp.users (
	username varchar(100) NOT NULL,
	salt VARBINARY(100) NOT NULL,
	hashedpassword VARBINARY(100) NOT NULL,
	name varchar(100) NOT NULL,
	dateofbirth DATETIME NOT NULL,
	CONSTRAINT users_pk PRIMARY KEY (username)
)