package com.tobeto.rentACar.controllers.concretes;

import com.tobeto.rentACar.entities.concretes.Customer;
import com.tobeto.rentACar.services.abstracts.CustomerService;
import com.tobeto.rentACar.services.dtos.customers.request.AddCustomerRequest;
import com.tobeto.rentACar.services.dtos.customers.request.DeleteCustomerRequest;
import com.tobeto.rentACar.services.dtos.customers.request.UpdateCustomerRequest;
import com.tobeto.rentACar.services.dtos.customers.response.GetAllCustomerResponse;
import com.tobeto.rentACar.services.dtos.customers.response.GetCustomerAgeResponse;
import com.tobeto.rentACar.services.dtos.customers.response.GetCustomerBirthdayResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomerControllers {
    private CustomerService customerService;

    public CustomerControllers(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<GetAllCustomerResponse> getAll(){
        return customerService.getAllCustomers();
    }

    @GetMapping("firstName")
    public  List<Customer> getByFirstname(@RequestParam String firstName){
        return customerService.getByFirstName(firstName);
    }
    @GetMapping("lastName")
    public List<Customer> getByLastName(@RequestParam String lastName){
        return customerService.getByLastName(lastName);
    }
    @GetMapping("{firstNameBirthday}")
    public List<GetCustomerBirthdayResponse> getCustomerBirthdayResponse(@RequestParam String firstName){
        return customerService.getCustomerBirthday(firstName);
    }

    @PostMapping
    public void add(@RequestBody AddCustomerRequest request){
        customerService.addCustomer(request);
    }

    @DeleteMapping("{internationalId}")
    public void delete(@RequestBody DeleteCustomerRequest request){
        customerService.deleteCustomer(request);
    }

    @PutMapping("{internationalId}")
    public void update (@PathVariable String internationalId, @RequestBody UpdateCustomerRequest request){
        customerService.updateCustomer(internationalId,request);
    }

    /*TODO:
        @GetMapping("{firstNameFroAge}")
    public List<GetCustomerAgeResponse> getCustomerAgeResponse(@RequestParam String firstName){
        return customerService.getCustomerAge(firstName);
    }
     */
}
