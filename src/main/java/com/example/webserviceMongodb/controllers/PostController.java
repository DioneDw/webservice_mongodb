package com.example.webserviceMongodb.controllers;

import com.example.webserviceMongodb.domain.dto.PostRecord;
import com.example.webserviceMongodb.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/posts")
public class PostController {
    @Autowired
    private PostService service;

    @GetMapping("/{id}")
    public ResponseEntity<PostRecord> findById(@PathVariable String id){
        return ResponseEntity.ok().body(service.findById(id));
    }

}
