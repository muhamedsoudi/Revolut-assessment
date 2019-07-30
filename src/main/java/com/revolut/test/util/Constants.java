package com.revolut.test.util;

public interface Constants {

	String TRANSACTION_LOG_CREATION_SCRIPT = "DROP TABLE IF EXISTS ACCOUNT_TRANSACTION;CREATE TABLE IF NOT EXISTS ACCOUNT_TRANSACTION\n" + "(\n"
			+ "ID  INT PRIMARY KEY, \n" + "FROM_ACCOUNT_ID INT,\n" + "TO_ACCOUNT_ID INT,\n"
			+ "AMOUNT DECIMAL ,\n" + "FOREIGN KEY (FROM_ACCOUNT_ID) REFERENCES ACCOUNT(accountId),\n"
			+ "FOREIGN KEY (TO_ACCOUNT_ID) REFERENCES ACCOUNT(accountId)\n" + ");\n";
	String ACCOUNT_TABLE_CREATION_SCRIPT = "DROP TABLE IF EXISTS ACCOUNT;CREATE TABLE IF NOT EXISTS ACCOUNT(\n" +"accountId INT PRIMARY KEY"+"\n" + " ,currentAmount DECIMAL  \n" + ");";
	String ACCOUNT_INITILIZATION_SCRIPT="DELETE FROM ACCOUNT;INSERT INTO ACCOUNT(accountId, currentAmount) VALUES(1000,2000000);INSERT INTO ACCOUNT(accountId, currentAmount) VALUES(1001,5000000);";

}
