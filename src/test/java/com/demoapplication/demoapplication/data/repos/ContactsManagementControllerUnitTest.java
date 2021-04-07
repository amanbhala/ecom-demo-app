package com.demoapplication.demoapplication.data.repos;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.demoapplication.demoapplication.customers;
import com.demoapplication.demoapplication.material;
import com.demoapplication.demoapplication.supplier;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

import com.demoapplication.demoapplication.customers_repo;
import com.demoapplication.demoapplication.material_repo;
import com.demoapplication.demoapplication.supplier_repo;

// import com.hanselnpetal.domain.CustomerContact;
// import com.hanselnpetal.service.ContactsManagementService;



// @WebMvcTest(form_controller.class)  // To let our unit test know that we will be testing a MVC controller.
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
// @TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
//     DirtiesContextTestExecutionListener.class,
//    TransactionalTestExecutionListener.class,
//     DbUnitTestExecutionListener.class })
// @DatabaseSetup("classpath:test-datasets.xml")
public class ContactsManagementControllerUnitTest {
	
	@Autowired
    private TestEntityManager entityManager;

    @Autowired
    private customers_repo customers_repo;
    
    @Autowired
    private material_repo material_repo;

    @Autowired
    private supplier_repo supplier_repo;

    @Test
    public void testFindByEmail() {
		
        // Find an inserted record
        customers customer = new customers();
        customer.setEmail("a@gmail.com");

        // save test data
        entityManager.persist(customer);
        
        customers foundcustomer = customers_repo.findByemail("a@gmail.com");
        
        assertThat(foundcustomer.getEmail(), is(equalTo("a@gmail.com")));
    }
    
    @Test
    public void testFindByDetails() {
		
        // Find an inserted record
        material material = new material();
        material.setDetails("IT");

        // save test data
        entityManager.persist(material);
        
        material foundmaterial = material_repo.findByDetails("IT");
        
        assertThat(foundmaterial.getDetails(), is(equalTo("IT")));
    }

    @Test
    public void testFindByName() {
		
        // Find an inserted record
        supplier supplier = new supplier();
        supplier.setName("Aman");

        // save test data
        entityManager.persist(supplier);
        
        supplier foundsupplier = supplier_repo.findByname("Aman");
        
        assertThat(foundsupplier.getName(), is(equalTo("Aman")));
    }
	
}
