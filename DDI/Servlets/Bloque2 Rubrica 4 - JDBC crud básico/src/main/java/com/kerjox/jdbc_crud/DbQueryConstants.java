package com.kerjox.jdbc_crud;

public interface DbQueryConstants {

	String TABLE_NAME = "employee";
	String DATABASE_NAME = "tutorialDb";

	String USE_DATABASE_QUERY = "USE tutorialDb";

	// CREATE DDL COMMAND
	String CREATE_DATABASE_QUERY = "CREATE DATABASE IF NOT EXISTS tutorialDb;";
	String CREATE_TABLE_QUERY = "CREATE TABLE employee (emp_id INT(11) NOT NULL AUTO_INCREMENT, emp_fname VARCHAR(20) DEFAULT NULL, emp_lname VARCHAR(20) DEFAULT NULL, PRIMARY KEY (emp_id));";

	// ALTER DDL COMMAND
	String ALTER_TABLE_QUERY = "ALTER TABLE employee ADD COLUMN  emp_joining_date VARCHAR(20) DEFAULT NULL;";
	String ALTER_TABLE_WITH_AFTER_CLAUSE_QUERY = "ALTER TABLE employee ADD COLUMN  emp_dob date NULL AFTER  emp_lname;";

	// DROP DDL COMMAND
	String DROP_TABLE = "DROP TABLE employee";
	String DROP_DATABASE = "DROP DATABASE tutorialDb;";
	String DROP_COLUMN = "ALTER TABLE employee DROP COLUMN emp_lname;";
}
