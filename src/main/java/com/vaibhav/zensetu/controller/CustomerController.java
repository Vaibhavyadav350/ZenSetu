package com.vaibhav.zensetu.controller;

import com.vaibhav.zensetu.entity.CustomerEntity;
import com.vaibhav.zensetu.service.CustomerControllerService;
import org.apache.coyote.Response;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerControllerService customerControllerService;


    @PostMapping
    public ResponseEntity<CustomerEntity> addCustomer(@RequestBody CustomerEntity myCustomer) {
        try{
            myCustomer.setDate(LocalDateTime.now());
            customerControllerService.saveEntry(myCustomer);
            return new ResponseEntity<>(myCustomer, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping
    public List<CustomerEntity> getCustomers() {
        return customerControllerService.getAllCustomers();
    }

    @GetMapping("id/{myid}")
    public CustomerEntity getCustomer(@PathVariable ObjectId myid) {
        return customerControllerService.getCustomerById(myid);
    }

    @DeleteMapping("id/{myid}")
    public ResponseEntity<?> deleteCustomer(@PathVariable ObjectId myid) {
        customerControllerService.deleteCustomerById(myid);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("id/{id}")
    public CustomerEntity updateCustomer(@PathVariable ObjectId id, @RequestBody CustomerEntity updateCustomer) {




        customerControllerService.saveEntry(updateCustomer);
        return updateCustomer;
    }

}
