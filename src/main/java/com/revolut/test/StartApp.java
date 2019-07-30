package com.revolut.test;

import com.revolut.test.api.AccountApi;
import com.revolut.test.model.dao.AccountDao;
import com.revolut.test.service.AccountService;

public class StartApp {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		 
		AccountDao accountDao= new AccountDao();
		AccountService accountService=new AccountService(accountDao);
		AccountApi accountApi=new AccountApi(accountService);
	}

}
