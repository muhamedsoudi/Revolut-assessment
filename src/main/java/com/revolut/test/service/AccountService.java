package com.revolut.test.service;

import com.revolut.test.model.dao.AccountDao;
import com.revolut.test.model.domain.Account;

public class AccountService {

	private  AccountDao accountDao;
	public AccountService(AccountDao accountDao) {
		this.accountDao= accountDao;
	}
	
	public Account getAccountDetails(int accountId) {
		return accountDao.getAccount(accountId);
	}
	
	public boolean transferAmount(int fromAccountId, int toAccountId, long amount) {
		
		boolean isAmountAvailable=accountDao.isAmountAvailable(fromAccountId, amount);
		if(!isAmountAvailable)
			return false;
		
		boolean isAccountExist=accountDao.isAccountExist(toAccountId);
		if(!isAccountExist)
			return false;
		
		return accountDao.transferBetweenAccounts(fromAccountId, toAccountId, amount);
	}
	
}
