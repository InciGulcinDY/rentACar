package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.entities.concretes.Customer;
import com.tobeto.rentACar.services.dtos.customers.request.AddCustomerRequest;
import com.tobeto.rentACar.services.dtos.customers.request.DeleteCustomerRequest;
import com.tobeto.rentACar.services.dtos.customers.request.UpdateCustomerRequest;
import com.tobeto.rentACar.services.dtos.customers.response.GetAllCustomerResponse;
import com.tobeto.rentACar.services.dtos.customers.response.GetCustomerBirthdayResponse;
import com.tobeto.rentACar.services.dtos.customers.response.GetCustomerByFirstNameStartingWithResponse;
import com.tobeto.rentACar.services.dtos.customers.response.GetCustomerByLastNameStartingWithResponse;

import java.util.List;

public interface CustomerService {
    public List<GetAllCustomerResponse> getAllCustomers();
    public  List<GetCustomerByFirstNameStartingWithResponse> getByFirstName(String firstname);
    public List<GetCustomerByLastNameStartingWithResponse> getByLastName(String lastName);
    public List<GetCustomerBirthdayResponse> getCustomerBirthday(String firstName);
    public void addCustomer(AddCustomerRequest request);
    public void deleteCustomer(DeleteCustomerRequest request);
    public void updateCustomer(String internationalId, UpdateCustomerRequest request);

    //TODO: public List<Customer> getCustomerAge(String firstName);
}
