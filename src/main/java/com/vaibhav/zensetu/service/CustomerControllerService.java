package com.vaibhav.zensetu.service;

import com.vaibhav.zensetu.Repository.CustomerEntryRepo;
import com.vaibhav.zensetu.entity.CustomerEntity;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class CustomerControllerService {

    @Autowired
    private CustomerEntryRepo customerEntryRepo ;

    public void saveEntry(CustomerEntity customerEntity) {

        customerEntryRepo.save(customerEntity);
    }

    public List<CustomerEntity> getAllCustomers() {
        return customerEntryRepo.findAll();
    }

    public CustomerEntity getCustomerById(ObjectId id) {

        return customerEntryRepo.findById(id).orElse(null);

    }
    public void deleteCustomerById(ObjectId id) {
       customerEntryRepo.deleteById(id);

    }
}
