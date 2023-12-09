package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.dataAccess.concretes.CustomerRepository;
import com.tobeto.rentACar.entities.concretes.Customer;
import com.tobeto.rentACar.entities.concretes.DriverLicenceType;
import com.tobeto.rentACar.services.abstracts.CustomerService;
import com.tobeto.rentACar.services.abstracts.DriverLicenceTypeService;
import com.tobeto.rentACar.services.dtos.brands.response.GetBrandByBrandNameStartingWithResponse;
import com.tobeto.rentACar.services.dtos.customers.request.AddCustomerRequest;
import com.tobeto.rentACar.services.dtos.customers.request.DeleteCustomerRequest;
import com.tobeto.rentACar.services.dtos.customers.request.UpdateCustomerRequest;
import com.tobeto.rentACar.services.dtos.customers.response.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;
    private  final DriverLicenceTypeService driverLicenceTypeService;

    @Override
    public List<GetAllCustomerResponse> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<GetAllCustomerResponse> responses = customers.stream()
                .map(customer ->
                        new GetAllCustomerResponse(customer.getFirstName(),customer.getLastName(),
                                customer.getBirthday(),customer.getInternationalId()))
                .toList();
        return responses;
    }

    @Override
    public List<GetCustomerByFirstNameStartingWithResponse> getByFirstName(String firstname) {
        List<Customer> customers = customerRepository.findByFirstNameStartingWith(firstname);
        List<GetCustomerByFirstNameStartingWithResponse> responses = customers.stream()
                .map(customer ->
                        new GetCustomerByFirstNameStartingWithResponse
                                (customer.getFirstName(),customer.getLastName(),
                                        customer.getBirthday(),customer.getInternationalId()))
                .toList();
        return responses;
    }

    @Override
    public List<GetCustomerByLastNameStartingWithResponse> getByLastName(String lastName) {
        List<Customer> customers = customerRepository.findByLastNameStartingWith(lastName);
        List<GetCustomerByLastNameStartingWithResponse> responses = customers.stream()
                .map(customer ->
                        new GetCustomerByLastNameStartingWithResponse
                                (customer.getFirstName(), customer.getLastName(),
                                        customer.getBirthday(), customer.getInternationalId()))
                .toList();
        return responses;
    }

    @Override
    public List<GetCustomerBirthdayResponse> getCustomerBirthday(String firstName) {
        return customerRepository.getCustomerBirthday(firstName);
    }

    @Override
    public void addCustomer(AddCustomerRequest request) {
        Customer customer = new Customer();
        //Business Rule-1:
        if((customerRepository.existsCustomerByFirstName(request.getFirstName())+" "+
                customerRepository.existsCustomerByLastName(request.getLastName()))
                .equals(request.getFirstName()+" "+request.getLastName())) {
            throw new RuntimeException("Customer cannot be added a second time!");
        }
        //Business Rule-2:
        if (customerRepository.existsCustomerByInternationalId(request.getInternationalId())){
            throw new RuntimeException("The same International ID cannot be added twice!");
        }

        //Business Rule-3:
        if(Year.now().getValue() - request.getBirthday().getYear() < 18){
            throw new RuntimeException("Customer cannot be under 18 years of age!");
        }

        //Business Rule-4:
        if (request.getLicenceIssueDate() != null && LocalDateTime.now().isBefore(request.getLicenceIssueDate())){
            throw new RuntimeException("Invalid date!");
        }

        // Mapping:
        customer.setInternationalId(request.getInternationalId());
        customer.setBirthday((request.getBirthday()));
        customer.setLastName(request.getLastName());
        customer.setFirstName(request.getFirstName());
        customer.setLicenceIssueDate(request.getLicenceIssueDate());
        DriverLicenceType driverLicenceType = driverLicenceTypeService.getById(request.getDriverLicenceTypeId());
        customer.setDriverLicenceType(driverLicenceType);
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
        //Business Rule-1:
        if((customerRepository.existsCustomerByFirstName(request.getFirstName())+" "+
                customerRepository.existsCustomerByLastName(request.getLastName()))
                .equals(request.getFirstName()+" "+request.getLastName())) {
            throw new RuntimeException("Customer cannot be added a second time!");
        }
        //Business Rule-2:
        if (customerRepository.existsCustomerByInternationalId(request.getInternationalId())){
            throw new RuntimeException("The same International ID cannot be added twice!");
        }

        //Business Rule-3:
        if(Year.now().getValue() - request.getBirthday().getYear() < 18){
            throw new RuntimeException("Customer cannot be under 18 years of age!");
        }

        //Business Rule-4:
        if (request.getLicenceIssueDate() != null && LocalDateTime.now().isBefore(request.getLicenceIssueDate())){
            throw new RuntimeException("Invalid date!");
        }

        for (Customer customer : customers) {
            if(customer.getInternationalId().equals(internationalId)){
                customer.setInternationalId(request.getInternationalId());
                customer.setBirthday((request.getBirthday()));
                customer.setLastName(request.getLastName());
                customer.setFirstName(request.getFirstName());
                customer.setLicenceIssueDate(request.getLicenceIssueDate());
                DriverLicenceType driverLicenceType = driverLicenceTypeService.getById(request.getDriverLicenceTypeId());
                customer.setDriverLicenceType(driverLicenceType);
                customerRepository.save(customer);
            }
        }
    }

    @Override
    public Customer getById(int id) {
        return customerRepository.findById(id).orElseThrow();
    }
}
