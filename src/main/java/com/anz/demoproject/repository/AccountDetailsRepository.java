package com.anz.demoproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anz.demoproject.model.AccountDetails;

public interface AccountDetailsRepository extends JpaRepository<AccountDetails, String>{
	
	List<AccountDetails> findAll();

}
