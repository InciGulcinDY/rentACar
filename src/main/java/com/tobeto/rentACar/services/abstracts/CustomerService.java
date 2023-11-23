package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.services.dtos.customers.request.AddCustomerRequest;
import com.tobeto.rentACar.services.dtos.customers.request.DeleteCustomerRequest;
import com.tobeto.rentACar.services.dtos.customers.request.UpdateCustomerRequest;
import com.tobeto.rentACar.services.dtos.customers.response.GetAllCustomerResponse;

import java.util.List;

public interface CustomerService {
    public List<GetAllCustomerResponse> getAllCustomers();
    public void addCustomer(AddCustomerRequest request);
    public void deleteCustomer(DeleteCustomerRequest request);
    public void updateCustomer(String internationalId, UpdateCustomerRequest request);
}
