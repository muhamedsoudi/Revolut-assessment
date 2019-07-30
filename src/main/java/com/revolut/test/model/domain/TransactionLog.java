package com.revolut.test.model.domain;

public class TransactionLog {

	private String fromAccountId;
	private String toAccountId;
	private long transferedValue;
	
	public TransactionLog() {}

	public TransactionLog(String fromAccountId, String toAccountId, long transferedValue) {
		super();
		this.fromAccountId = fromAccountId;
		this.toAccountId = toAccountId;
		this.transferedValue = transferedValue;
	}

	public String getFromAccountId() {
		return fromAccountId;
	}

	public void setFromAccountId(String fromAccountId) {
		this.fromAccountId = fromAccountId;
	}

	public String getToAccountId() {
		return toAccountId;
	}

	public void setToAccountId(String toAccountId) {
		this.toAccountId = toAccountId;
	}

	public long getTransferedValue() {
		return transferedValue;
	}

	public void setTransferedValue(long transferedValue) {
		this.transferedValue = transferedValue;
	}
	
	
}
