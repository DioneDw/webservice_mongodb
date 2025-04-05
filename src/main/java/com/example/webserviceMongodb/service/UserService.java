package com.example.webserviceMongodb.service;

import com.example.webserviceMongodb.domain.User;
import com.example.webserviceMongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
        return repository.findById(id).orElseThrow(()-> new RuntimeException("User not found!"));
    }

    public User findByName(String name){
        return repository.findByName(name).orElseThrow(()-> new RuntimeException("User not found!"));
    }
}
