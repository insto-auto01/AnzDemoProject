package com.anz.demoproject.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.anz.demoproject.model.AccountDetails;
import com.anz.demoproject.model.TransactionDetails;
import com.anz.demoproject.repository.AccountDetailsRepository;
import com.anz.demoproject.repository.TransactionRepository;


@RunWith(SpringRunner.class)
@WebMvcTest(AnzService.class)
public class AnzServiceTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@Autowired
	AnzService anzService;
	
	@MockBean
	AccountDetailsRepository accountDetailsRepository;
	
	@MockBean
	TransactionRepository transactionRepository;
	
	
	@Test
	public void getAccountDetailsTest() throws Exception{
		List<AccountDetails> expectedResponse = new ArrayList<AccountDetails>();
		AccountDetails details = new AccountDetails();
		details.setAccountName("SGSSavings726");
		details.setAccountNumber(585309209);
		details.setAccountType("saving");
		details.setBalanceDate(new Date());
		details.setCurrency("SGD");
		details.setOpeningBalance(84327.51);
		expectedResponse.add(details);
		AccountDetails details1 = new AccountDetails();
		details1.setAccountName("AUSavings933");
		details1.setAccountNumber(791066619);
		details1.setAccountType("current");
		details1.setBalanceDate(new Date());
		details1.setCurrency("AUD");
		details1.setOpeningBalance(88005.93);
		expectedResponse.add(details1);
		
		Mockito.when(accountDetailsRepository.findAll()).thenReturn(expectedResponse);
		
		assertThat(anzService.getAccountDetails()).isEqualTo(expectedResponse);	
	}
	
	@Test
	public void getAllTransactionTest() throws Exception{
		List<TransactionDetails> expectedResponse = new ArrayList<TransactionDetails>();
		TransactionDetails details = new TransactionDetails();
		details.setTransactionNumber(1);
		details.setAccountName("SGSSavings726");
		details.setAccountNumber(585309209);
		details.setValueDate(new Date());
		details.setCreditAmount(9540.98);
		details.setCurrency("SGD");
		details.setDebitAmount(0);
		details.setDebitCredit("credit");
		details.setTransactionNarative(null);
		expectedResponse.add(details);
		
		TransactionDetails details1 = new TransactionDetails();
		details1.setTransactionNumber(1);
		details1.setAccountName("SGSSavings726");
		details1.setAccountNumber(585309209);
		details1.setValueDate(new Date());
		details1.setCreditAmount(9540.98);
		details1.setCurrency("SGD");
		details1.setDebitAmount(0);
		details1.setDebitCredit("credit");
		details1.setTransactionNarative(null);
		expectedResponse.add(details1);
		
		Mockito.when(transactionRepository.findAll()).thenReturn(expectedResponse);
		
		assertThat(anzService.getAllTransaction(585309209)).isEqualTo(expectedResponse);	
	}
	
	

}
