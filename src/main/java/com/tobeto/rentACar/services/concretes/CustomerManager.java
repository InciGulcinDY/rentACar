package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.dataAccess.concretes.CustomerRepository;
import com.tobeto.rentACar.entities.concretes.Customer;
import com.tobeto.rentACar.services.abstracts.CustomerService;
import com.tobeto.rentACar.services.dtos.cars.response.GetAllCarsResponse;
import com.tobeto.rentACar.services.dtos.customers.request.AddCustomerRequest;
import com.tobeto.rentACar.services.dtos.customers.request.DeleteCustomerRequest;
import com.tobeto.rentACar.services.dtos.customers.request.UpdateCustomerRequest;
import com.tobeto.rentACar.services.dtos.customers.response.GetAllCustomerResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerManager implements CustomerService {
    private CustomerRepository customerRepository;

    public CustomerManager(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<GetAllCustomerResponse> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<GetAllCustomerResponse> responses = new ArrayList<>();
        for (Customer customer:customers) {
            GetAllCustomerResponse responseItem = new GetAllCustomerResponse();
            responseItem.setBirthday(customer.getBirthday());
            responseItem.setFirstName(customer.getFirstName());
            responseItem.setInternationalId(customer.getInternationalId());
            responseItem.setLastName(customer.getLastName());
            responses.add(responseItem);
        }
        return responses;
    }

    @Override
    public void addCustomer(AddCustomerRequest request) {
        Customer customer = new Customer();
        customer.setInternationalId(request.getInternationalId());
        customer.setBirthday((request.getBirthday()));
        customer.setLastName(request.getLastName());
        customer.setFirstName(request.getFirstName());
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(DeleteCustomerRequest request) {
        List<Customer> customers = customerRepository.findAll();
        for (Customer customer:customers) {
            if (customer.getInternationalId().equals(request.getInternationalId())){
                request.setId(customer.getId());
            }
        }
        //Checking the existance of the car
        customerRepository.findById(request.getId()).orElseThrow();
        //Delete the customer
        customerRepository.deleteById(request.getId());
    }

    @Override
    public void updateCustomer(String internationalId, UpdateCustomerRequest request) {
        List<Customer> customers = customerRepository.findAll();
        for (Customer customer : customers) {
            if(customer.getInternationalId().equals(internationalId)){
                request.setInternationalId(customer.getInternationalId());
                customer.setBirthday(request.getBirthday());
                customer.setFirstName(request.getFirstName());
                customer.setLastName(request.getLastName());
                customer.setInternationalId(request.getInternationalId());
                customerRepository.save(customer);
            }
        }
        //Checking the existance of the brand
        customerRepository.findById(request.getId()).orElseThrow();
    }
}
