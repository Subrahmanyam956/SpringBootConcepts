package com.SpringbootPractice.ConnectingToMultipleMongodbDatabases.service;

import com.SpringbootPractice.ConnectingToMultipleMongodbDatabases.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class CustomerService {

    @Autowired
    private MongoTemplate customerMongoDb;
    public Customer saveCustomer(Customer customer) {
        return customerMongoDb.save(customer);
    }

    public Customer getCustomer(String customerId) {
        return customerMongoDb.findById(customerId, Customer.class);
    }
}
