package com.tobeto.rentACar.dataAccess.concretes;

import com.tobeto.rentACar.entities.concretes.Customer;
import com.tobeto.rentACar.services.dtos.customers.response.GetCustomerBirthdayResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByFirstNameStartingWith(String firstName); // Derived Query Methods
    List<Customer> findByLastNameStartingWith(String lastName); // Derived Query Methods

    @Query("SELECT new com.tobeto.rentACar.services.dtos.customers.response.GetCustomerBirthdayResponse(c.firstName, c.lastName, c.birthday) " +
            "FROM Customer c " +
            "WHERE c.firstName = :firstName")
    List<GetCustomerBirthdayResponse> getCustomerBirthday(String firstName);    // JPQL Methods

    boolean existsCustomerByFirstName(String firstName);    // JPQL Methods
    boolean existsCustomerByLastName(String lastName);  // JPQL Methods

    boolean existsCustomerByInternationalId(String internationalId);


}
