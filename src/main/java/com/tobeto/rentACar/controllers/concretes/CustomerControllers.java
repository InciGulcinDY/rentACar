package com.tobeto.rentACar.controllers.concretes;

import com.tobeto.rentACar.dataAccess.concretes.CustomerRepository;
import com.tobeto.rentACar.entities.concretes.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomerControllers {
    private final CustomerRepository customerRepository;

    public CustomerControllers(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    @GetMapping("{id}")
    public Customer getById(@PathVariable int id){
        return customerRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Customer customer){
        customerRepository.save(customer);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Customer customerToBeDeleted = customerRepository.findById(id).orElseThrow();
        customerRepository.delete(customerToBeDeleted);
    }

    @PutMapping("{id}")
    public void update (@PathVariable int id, @RequestBody Customer customer){
        Customer customerToBeUpdated = customerRepository.findById(id).orElseThrow();
        customerToBeUpdated.setDriverLicenceType(customer.getDriverLicenceType());
        customerToBeUpdated.setBirthday(customer.getBirthday());
        customerToBeUpdated.setLicenceIssueDate(customer.getLicenceIssueDate());
        customerToBeUpdated.setFirstName(customer.getFirstName());
        customerToBeUpdated.setLastName(customer.getLastName());
        customerToBeUpdated.setInternationalId(customer.getInternationalId());
        customerRepository.save(customerToBeUpdated);
    }
}
