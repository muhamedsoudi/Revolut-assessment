package com.revolut.test.util;

import static com.revolut.test.util.Constants.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class DBIntilization {

	private final static String DB_URL = "jdbc:h2:~/revolut-test";
	private final static String USERNAME = "sa";
	private final static String PASSWORD = "";
	private static Sql2o sql2oInstance;

	private DBIntilization() {}

	public static Sql2o getSql2oInstance() {
		if (sql2oInstance == null) {
			// synchronized block to remove overhead
			synchronized (DBIntilization.class) {
				if (sql2oInstance == null) {
					// if instance is null, initialize
					sql2oInstance = new Sql2o(DB_URL, USERNAME, PASSWORD);
					if(intilizeDB()) {
						return sql2oInstance;
					}else {
						return null;
					}
				}
			}
		}
		return sql2oInstance;
	}
	
	private static boolean intilizeDB() {
		try (Connection con = sql2oInstance.beginTransaction()) {
			con.createQuery(ACCOUNT_TABLE_CREATION_SCRIPT+ACCOUNT_INITILIZATION_SCRIPT).executeUpdate();
			//con.createQuery(ACCOUNT_CREATION_SCRIPT).executeUpdate();
			con.createQuery(TRANSACTION_LOG_CREATION_SCRIPT).executeUpdate();
		    con.commit();
		  }
		return true;
	}
	
}