package com.anz.demoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anz.demoproject.model.TransactionDetails;

import java.lang.String;
import java.util.List;

public interface TransactionRepository extends JpaRepository<TransactionDetails, Integer> {
	
	List<TransactionDetails> findByAccountNumber(int accountnumber);

}
