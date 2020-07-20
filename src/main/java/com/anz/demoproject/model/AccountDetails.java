package com.anz.demoproject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="accountdetails")
public class AccountDetails {

	@Id
	@Column(name="accountnumber")
	private int accountNumber;
	
	@Column(name="accountname")
	private String accountName;
	
	@Column(name="accounttype")
	private String accountType;
	
	@Column(name="balancedate")
	private Date balanceDate;
	
	@Column(name="currency")
	private String currency;
	
	@Column(name="openingavailablebalance")
	private Double openingBalance;

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Date getBalanceDate() {
		return balanceDate;
	}

	public void setBalanceDate(Date balanceDate) {
		this.balanceDate = balanceDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(Double openingBalance) {
		this.openingBalance = openingBalance;
	}
	
	
}
