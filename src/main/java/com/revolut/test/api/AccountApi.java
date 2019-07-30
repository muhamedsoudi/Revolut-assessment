package com.revolut.test.api;

import static spark.Spark.post;

import com.google.gson.Gson;
import com.revolut.test.model.dto.TransferAmountDTO;
import com.revolut.test.service.AccountService;


public class AccountApi {

	private AccountService accountService;
	
	public AccountApi(AccountService accoService) {
		this.accountService=accoService;
		
	    post("/transfer-money", (request, response) -> {
	    	
	    	response.type("application/json");
		    TransferAmountDTO transferAmountDTO = new Gson().fromJson(request.body(), TransferAmountDTO.class);
		    
		    try {
		    	boolean isTransfered=accountService.transferAmount(transferAmountDTO.getFromAccountId(), transferAmountDTO.getToAccountId(), transferAmountDTO.getAmount());
			     if(!isTransfered) {
			    	 response.status(500);
			    	 return "Failed To Transfer given Amount between accounts..";
			     }else {
			    	 response.status(200);
			    	 return "Amount Transfered successfully..";
			     }
		    }catch(Exception ex) {
		    	response.status(500);
		    	return"Failed To Transfer Money with Failure Message:"+ ex.getMessage();
		    }   
	    });
	}
}