package com.SpringbootPractice.ConnectingToMultipleMongodbDatabases.controller;

import com.SpringbootPractice.ConnectingToMultipleMongodbDatabases.model.Customer;
import com.SpringbootPractice.ConnectingToMultipleMongodbDatabases.service.CustomerService;
import org.springframework.web.bind.annotation.*;

@RestController("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/save")
    public String saveCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerService.saveCustomer(customer);
        return "customer Id : " + newCustomer.getCustomerId();
    }

    @GetMapping("/findById/{customerId}")
    public Customer getCustomer(@PathVariable String customerid) {
        return customerService.getCustomer(customerid);
    }

}
