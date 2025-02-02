package com.vaibhav.zensetu.service;

import com.vaibhav.zensetu.Repository.DeveloperRepo;
import com.vaibhav.zensetu.entity.DeveloperEntity;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeveloperService {
    @Autowired
    private DeveloperRepo developerRepo;


    public List<DeveloperEntity> getAllDevelopers() {
        return developerRepo.findAll();
    }
    public DeveloperEntity getDevelopersById(ObjectId id) {
        return developerRepo.findById(id).orElse(null);

    }
    public void addDeveloper(DeveloperEntity developer) {
        developerRepo.save(developer);
    }
     public void deleteDeveloper(ObjectId id) {
        developerRepo.deleteById(id);
     }

     public DeveloperEntity findDeveloperName(String username) {
        return developerRepo.findByusername(username);
     }
}
