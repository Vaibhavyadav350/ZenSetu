package com.vaibhav.zensetu.Repository;

import com.vaibhav.zensetu.entity.CustomerEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface CustomerEntryRepo extends MongoRepository<CustomerEntity, ObjectId> {

}
// controller --> service --> repo --> entity -->db