package com.vaibhav.zensetu.Repository;

import com.vaibhav.zensetu.entity.DeveloperEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface DeveloperRepo  extends MongoRepository<DeveloperEntity, ObjectId> {
    DeveloperEntity findByusername(String username);
}
