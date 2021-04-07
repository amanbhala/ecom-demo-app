package com.demoapplication.demoapplication.service;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.demoapplication.demoapplication.controller.ContactsManagementControllerIntegrationTest;
import com.demoapplication.demoapplication.data.repos.ContactsManagementControllerUnitTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(Suite.class)
@SpringBootTest
@AutoConfigureMockMvc
@Suite.SuiteClasses ({ContactsManagementControllerUnitTest.class, ContactsManagementControllerIntegrationTest.class})
class DemoapplicationApplicationTests {

	// @Test
	// void contextLoads() {
	// }
	// @Autowired
    // private MockMvc mockMvc;

    // @Test
    // public void shouldReturnDefaultMessage() throws Exception {
    //     this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
    //             .andExpect(content().string(containsString("Hello World")));
    // }

}




