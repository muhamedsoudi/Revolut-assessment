package com.revolut.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.revolut.test.model.dao.AccountDao;

public class AccountServiceTest {

	private static AccountDao accountDao;
	
	static{
		accountDao=new AccountDao();
	}
	
	@Test
	public void canTransferAmount() {
		int fromAccountId = 1000;
		long fromAccountAmount= accountDao.getAccountAmount(fromAccountId);
		int toAccountId = 1001;
		long toAccountAmount= accountDao.getAccountAmount(toAccountId);
		long transferedAmount= 100;
		
		accountDao.transferBetweenAccounts(fromAccountId, toAccountId, transferedAmount);
		
		assertTrue(accountDao.getAccountAmount(fromAccountId)==(fromAccountAmount-transferedAmount));
		assertTrue(accountDao.getAccountAmount(toAccountId)==(toAccountAmount+transferedAmount));
		
		
	}
}
