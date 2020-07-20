package com.anz.demoproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anz.demoproject.constants.AnzConstants;
import com.anz.demoproject.model.AccountDetails;
import com.anz.demoproject.model.TransactionDetails;
import com.anz.demoproject.service.AnzService;

@RestController
@RequestMapping("/anz")
public class AnzController {
	
	@Autowired
	AnzService anzService;
	
	
	@GetMapping("/accounts")
	public ResponseEntity<?> getAccountDetails(){
		List<AccountDetails> response = null;
		try {
			response = anzService.getAccountDetails();
			
			if(response==null) {
				return new ResponseEntity<>(AnzConstants.ErrorConstants.JSON_START_STRING
						+AnzConstants.ErrorConstants.NO_CONTENT
						+AnzConstants.ErrorConstants.JSON_END_STRING,
						HttpStatus.NO_CONTENT);
			}
		}catch(Exception e) {
			return new ResponseEntity<>(AnzConstants.ErrorConstants.JSON_START_STRING
					+AnzConstants.ErrorConstants.BAD_REQUEST
					+AnzConstants.ErrorConstants.JSON_END_STRING,
					HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping("/transaction/{accountNumber}")
	public ResponseEntity<?> getAccountTransaction(@PathVariable int accountNumber){
		List<TransactionDetails> response = null;
		try {
			response = anzService.getAllTransaction(accountNumber);
			if(response==null) {
				return new ResponseEntity<>(AnzConstants.ErrorConstants.JSON_START_STRING
						+AnzConstants.ErrorConstants.NO_CONTENT
						+AnzConstants.ErrorConstants.JSON_END_STRING,
						HttpStatus.NO_CONTENT);
			}
		}catch(Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(AnzConstants.ErrorConstants.JSON_START_STRING
					+AnzConstants.ErrorConstants.BAD_REQUEST
					+AnzConstants.ErrorConstants.JSON_END_STRING,
					HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}

}
