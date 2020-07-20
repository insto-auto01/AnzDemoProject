package com.anz.demoproject.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import com.anz.demoproject.service.AnzService;

@RunWith(SpringRunner.class)
@WebMvcTest(AnzController.class)
public class AnzControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
	AnzService anzService;
	
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
		
		Mockito.when(anzService.getAccountDetails()).thenReturn(expectedResponse);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/anz/accounts");
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse  actualResponse = result.getResponse();
				
		assertThat(actualResponse).isEqualTo(expectedResponse);	
	}
	
	@Test
	public void getAccountDetailsExceptionTest() throws Exception{
		List<AccountDetails> expectedResponse = null;
		Mockito.when(anzService.getAccountDetails()).thenReturn(expectedResponse);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/anz/accounts");
		
		MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isBadRequest()).andReturn();
		MockHttpServletResponse  actualResponse = result.getResponse();
		
		assertThat(actualResponse).isEqualTo(new Exception());
	}
	
	
	@Test
	public void getTransactionDetailsTest() throws Exception{
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
		
		Mockito.when(anzService.getAllTransaction(Mockito.anyInt())).thenReturn(expectedResponse);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/anz/transaction/585309209");
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse  actualResponse = result.getResponse();
				
		assertThat(actualResponse).isEqualTo(expectedResponse);	
	}
	
	@Test
	public void getTransactionDetailsExceptionTest() throws Exception{
		List<TransactionDetails> expectedResponse = null;
		Mockito.when(anzService.getAllTransaction(Mockito.anyInt())).thenReturn(expectedResponse);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/anz/transaction/585309209");
		
		MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isBadRequest()).andReturn();
		MockHttpServletResponse  actualResponse = result.getResponse();
		
		assertThat(actualResponse).isEqualTo(new Exception());
	}
	
}
