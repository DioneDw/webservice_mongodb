package com.example.webserviceMongodb.service;

import com.example.webserviceMongodb.domain.User;
import com.example.webserviceMongodb.domain.dto.UserRecord;
import com.example.webserviceMongodb.mapper.PostMapper;
import com.example.webserviceMongodb.mapper.UserMapper;
import com.example.webserviceMongodb.repository.UserRepository;
import com.example.webserviceMongodb.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PostMapper postMapper;

    public List<UserRecord> findAll(){
        return repository.findAll().stream()
                .map(x-> new UserRecord(x.getId(),x.getName(), x.getEmail(), postMapper.toRecordList(x.getPosts()))).toList();
    }

    public UserRecord findById(String id){
        User user = repository.findById(id).orElseThrow(ObjectNotFoundException::new);
        return new UserRecord(user.getId(), user.getName(), user.getEmail(), postMapper.toRecordList(user.getPosts()));
    }

    public UserRecord findByName(String name){
        User user = repository.findByName(name).orElseThrow(ObjectNotFoundException::new);
        return new UserRecord(user.getId(), user.getName(), user.getEmail(), postMapper.toRecordList(user.getPosts()));
    }

    public UserRecord create(UserRecord userRecord){
        return userMapper.toRecord(repository.save(userMapper.toEntity(userRecord)));
    }

    public void deleteById(String id){
        repository.findById(id);
        repository.deleteById(id);
    }

    public void update(String id, UserRecord userRecord){
        User entity = repository.findById(id)
                .orElseThrow(ObjectNotFoundException::new);
        dataUpdate(entity,userRecord);
        repository.save(entity);
    }

    private void dataUpdate(User entity, UserRecord userRecord){
        Optional.ofNullable(userRecord.name()).ifPresent(entity::setName);
        Optional.ofNullable(userRecord.email()).ifPresent(entity::setEmail);
    }
}
