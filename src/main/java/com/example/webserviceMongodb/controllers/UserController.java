package com.example.webserviceMongodb.controllers;

import com.example.webserviceMongodb.domain.dto.UserRecord;
import com.example.webserviceMongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserRecord>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public UserRecord findById(@PathVariable String id){
        return service.findById(id);
    }

    @GetMapping("/name/{name}")
    public UserRecord findByName(@PathVariable String name){
        return service.findByName(name);
    }


}
