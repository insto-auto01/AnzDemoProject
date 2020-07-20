package com.anz.demoproject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transactiondetails")
public class TransactionDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="transactionnumber")
	private int transactionNumber;
	
	@Column(name="accountnumber")
	private int accountNumber;
	
	@Column(name="accountname")
	private String accountName;
	
	@Column(name="valuedate")
	private Date valueDate;
	
	@Column(name="currency")
	private String currency;
	
	@Column(name="debitamount")
	private double debitAmount;
	
	@Column(name="creditamount")
	private double creditAmount;
	
	@Column(name="debitcredit")
	private String debitCredit;
	
	@Column(name="transactionnarrative")
	private String transactionNarative;

	public int getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(int transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

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

	public Date getValueDate() {
		return valueDate;
	}

	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(double debitAmount) {
		this.debitAmount = debitAmount;
	}

	public double getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(double creditAmount) {
		this.creditAmount = creditAmount;
	}

	public String getDebitCredit() {
		return debitCredit;
	}

	public void setDebitCredit(String debitCredit) {
		this.debitCredit = debitCredit;
	}

	public String getTransactionNarative() {
		return transactionNarative;
	}

	public void setTransactionNarative(String transactionNarative) {
		this.transactionNarative = transactionNarative;
	}
	
	

}
