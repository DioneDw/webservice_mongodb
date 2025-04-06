package com.example.webserviceMongodb.controllers;

import com.example.webserviceMongodb.domain.dto.PostRecord;
import com.example.webserviceMongodb.domain.dto.UserRecord;
import com.example.webserviceMongodb.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
    public ResponseEntity<UserRecord> findById(@PathVariable String id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<UserRecord> findByName(@PathVariable String name){
        return ResponseEntity.ok().body(service.findByName(name));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody UserRecord userRecord){
        return ResponseEntity.created(ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(service
                        .create(userRecord)
                        .id())
                .toUri())
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody @Valid UserRecord userRecord){
        service.update(id,userRecord);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/posts")
    public ResponseEntity<List<PostRecord>> findPosts(@PathVariable String id){
        return ResponseEntity.ok().body(service.findById(id).posts());
    }

}
