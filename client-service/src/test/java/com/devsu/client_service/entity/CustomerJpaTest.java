package com.devsu.client_service.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.assertj.core.api.Assertions.assertThat;

import com.devsu.client_service.enums.Gender;
import com.devsu.client_service.model.Customer;

@DataJpaTest
public class CustomerJpaTest {
    
    @Autowired
    private TestEntityManager entityManager;

    @Test
    void shouldPersistAndRetrieveCustomer() {
        // DADO EL SIGUIENTE CLIENTE
        Customer customer = new Customer();
        customer.setName("Juan Valdez");
        customer.setGender(Gender.M);
        customer.setAge(25);
        customer.setIdentification("8-888-888");
        customer.setAddress("Ciudad de Panama, Panama");
        customer.setPhoneNumber("+50765656363");
        customer.setPassword("devsupassword");

        // CUANDO SE GUARDA
        Customer savedCustomer = entityManager.persistAndFlush(customer);

        // ENTONCES RESULTA
        assertThat(savedCustomer.getId()).isNotNull();
        assertThat(savedCustomer.getName()).isEqualTo("Juan Valdez");
        
        Customer foundCustomer = entityManager.find(Customer.class, savedCustomer.getId());
        assertThat(foundCustomer).isNotNull();
        assertThat(foundCustomer.getName()).isEqualTo("Juan Valdez");
    }

}
