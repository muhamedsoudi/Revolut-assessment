package com.revolut.test.model.dao;

import java.util.List;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import com.revolut.test.model.domain.Account;
import com.revolut.test.util.DBIntilization;

public class AccountDao {

	private static Sql2o sql2o;
	static{
		sql2o= DBIntilization.getSql2oInstance();
	}
	
	public boolean transferBetweenAccounts(int fromAccountId, int toAccountId, long amount) {
		
		if(fromAccountId<1 || toAccountId <1 || amount<1)
			return false;
		
		String query="UPDATE ACCOUNT SET currentAmount=(currentAmount+:amount) where accountId=:toAccountId;"
				   + "UPDATE ACCOUNT SET currentAmount=(currentAmount-:amount) where accountId=:fromAccountId;";
		
		try (Connection con = sql2o.beginTransaction()) {
			
			int updatedAccount=con.createQuery(query)
					.addParameter("toAccountId", toAccountId)
					.addParameter("fromAccountId", fromAccountId)
					.addParameter("amount", amount)
					.executeUpdate().getResult();
			    con.commit();
			return (updatedAccount==1);
		 }catch(Exception ex) {
		        System.err.println(ex.getMessage());
		        return false;
		     }
	}
	
	public long getAccountAmount(int accountId) {
		try (Connection con = sql2o.open()) {
			List<Account> account=con.createQuery("select accountId, currentAmount from ACCOUNT where accountId=:accountId")
				.addParameter("accountId", accountId)
				.executeAndFetch(Account.class);
		    return (account !=null && !account.isEmpty()) ? account.get(0).getCurrentAmount() : -1;
		 }catch(Exception ex) {
	        System.err.println(ex.getMessage());
	        return -1;
	     }
	}
	
	public Account getAccount(int accountId) {
		try (Connection con = sql2o.open()) {
			List<Account> account=con.createQuery("select accountId, currentAmount from ACCOUNT where accountId=:accountId")
				.addParameter("accountId", accountId)
				.executeAndFetch(Account.class);
		    return (account !=null && !account.isEmpty()) ? account.get(0) : null;
		 }catch(Exception ex) {
	        System.err.println(ex.getMessage());
	        return null;
	     }
	}
	
	public boolean isAccountExist(int accountId) {
		try (Connection conn = sql2o.open()) {
           Integer accountNo =conn.createQuery("select count(accountId) from ACCOUNT where accountId=:accountId")
        		    .addParameter("accountId", accountId)
                    .executeScalar(Integer.class);
            return (accountNo !=null && accountNo==1 );
        }catch(Exception ex) {
        	System.err.println(ex.getMessage());
        	return false;
        }
	}
	
	public boolean isAmountAvailable(int accountId, long amount) {
		try (Connection conn = sql2o.open()) {
	           Integer accountNo = conn.createQuery("select count(accountId) from ACCOUNT where accountId=:accountId AND currentAmount >= :amount")
	                    .addParameter("accountId", accountId)
	                    .addParameter("amount", amount)
	                    .executeScalar(Integer.class);
	           return (accountNo !=null && accountNo==1 );
        }catch(Exception ex) {
        	System.err.println("Exception With Message:"+ex.getMessage());
        	return false;
        }
	}
	
	
}
