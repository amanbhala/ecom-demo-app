package com.demoapplication.demoapplication.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;


import com.demoapplication.demoapplication.customers;
import com.demoapplication.demoapplication.form_controller;
// import com.hanselnpetal.domain.CustomerContact;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ContactsManagementControllerIntegrationTest {

	@Autowired
	form_controller form_controller;
	
	@Test
	public void testAddContactFirstNameMissing() {
		customers customer = new customers();
		
		// POST our CustomerContact form bean to the controller; check the outcome
		List<customers> outcome = form_controller.viewdetails_customer(customer);
				
		// Assert THAT the outcome is as expected
		assertEquals(outcome.get(0), customer);
		
	}
	
	@Test
	public void testAddContactHappyPath() {
		
		customers customer = new customers();
		// aContact.setFirstName("Jenny");
		// aContact.setLastName("Johnson");
		customer.setCust_id(1);
		customer.setEmail("a@gmail.com");
		customer.setMobile("9876543210");
		customer.setName("Aman");


		// POST our CustomerContact form bean to the controller; check the outcome
		List<customers> outcome = form_controller.viewdetails_customer(customer);
		
		// Assert THAT the outcome is as expected
		// ObjectMapper objectMapper = new ObjectMapper();
		// String jsonString = objectMapper.writeValueAsString(customer);
		assertEquals(outcome.get(0), customer);
	}
	
	
}
