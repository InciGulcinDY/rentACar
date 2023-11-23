package com.tobeto.rentACar.controllers.concretes;

import com.tobeto.rentACar.services.abstracts.CustomerService;
import com.tobeto.rentACar.services.dtos.customers.request.AddCustomerRequest;
import com.tobeto.rentACar.services.dtos.customers.request.DeleteCustomerRequest;
import com.tobeto.rentACar.services.dtos.customers.request.UpdateCustomerRequest;
import com.tobeto.rentACar.services.dtos.customers.response.GetAllCustomerResponse;
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
}
