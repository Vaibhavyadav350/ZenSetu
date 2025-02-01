package com.vaibhav.zensetu.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "customer")
@Data
public class CustomerEntity {


    @Id
    private ObjectId customerID;
    private LocalDateTime date;
    private String customerName;
    private String customerAddress;
    private String customerPhone;
    private String customerEmail;

}
