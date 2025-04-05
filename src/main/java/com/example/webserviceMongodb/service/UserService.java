package com.example.webserviceMongodb.service;

import com.example.webserviceMongodb.domain.User;
import com.example.webserviceMongodb.domain.dto.UserRecord;
import com.example.webserviceMongodb.mapper.UserMapper;
import com.example.webserviceMongodb.repository.UserRepository;
import com.example.webserviceMongodb.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper mapper;

    public List<UserRecord> findAll(){
        return repository.findAll().stream()
                .map(x-> new UserRecord(x.getId(),x.getName(), x.getEmail()))
                .toList();
    }

    public UserRecord findById(String id){
        User user = repository.findById(id).orElseThrow(ObjectNotFoundException::new);
        return new UserRecord(user.getId(), user.getName(), user.getEmail());
    }

    public UserRecord findByName(String name){
        User user = repository.findByName(name).orElseThrow(ObjectNotFoundException::new);
        return new UserRecord(user.getId(), user.getName(), user.getEmail());
    }

    public UserRecord create(UserRecord userRecord){
        return mapper.toRecord(repository.save(mapper.toEntity(userRecord)));
    }
}
