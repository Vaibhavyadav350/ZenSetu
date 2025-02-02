package com.vaibhav.zensetu.controller;
import com.vaibhav.zensetu.entity.DeveloperEntity;
import com.vaibhav.zensetu.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("developer")
public class DeveloperController {

    @Autowired
    private DeveloperService developerService;

    @GetMapping
    public ResponseEntity<?>  getDeveloper() {
        try {
            return new ResponseEntity<>(developerService.getAllDevelopers(), HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }
    @PostMapping
    public ResponseEntity<?> createDeveloper(@RequestBody DeveloperEntity developer) {
        developerService.addDeveloper(developer);
        try{
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @PutMapping("/{username}")
    public ResponseEntity<?> updateDeveloper(@RequestBody DeveloperEntity developer , @PathVariable String username) {

        DeveloperEntity devinDb = developerService.findDeveloperName(username);
        if (devinDb != null) {
            devinDb.setUsername(developer.getUsername());
            devinDb.setPassword(developer.getPassword());
            developerService.addDeveloper(devinDb);
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
