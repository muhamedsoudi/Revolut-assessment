package com.revolut.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.revolut.test.model.dao.AccountDao;

public class AccountDaoTest {

	private static AccountDao accountDao;
	static{
		accountDao=new AccountDao();
	}
	
	
	@Test
	public void accountExist() {
		assertTrue(accountDao.isAccountExist(1000));
	}
	
	@Test
	public void accountNotExist() {
		assertTrue(!accountDao.isAccountExist(1));
	}
	
	@Test
	public void amountIsAvailable() {
		assertTrue(accountDao.isAmountAvailable(1000, 1000));
	}
	
	@Test
	public void amountIsNotAvailable() {
		assertTrue(!accountDao.isAmountAvailable(1000,90000000));
	}
	
}
