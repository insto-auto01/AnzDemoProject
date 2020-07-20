package com.anz.demoproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anz.demoproject.model.AccountDetails;
import com.anz.demoproject.model.TransactionDetails;
import com.anz.demoproject.repository.AccountDetailsRepository;
import com.anz.demoproject.repository.TransactionRepository;

@Service
public class AnzService {
	
	@Autowired
	AccountDetailsRepository accountDetailsRepository;
	
	@Autowired
	TransactionRepository transactionRepository;
	
	
	public List<AccountDetails> getAccountDetails() {
		 return accountDetailsRepository.findAll();
	}
	
	
	public List<TransactionDetails> getAllTransaction(int accountnumber) {
		 return transactionRepository.findByAccountNumber(accountnumber);
	}

}
