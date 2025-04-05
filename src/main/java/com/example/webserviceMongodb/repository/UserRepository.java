package com.example.webserviceMongodb.repository;

import com.example.webserviceMongodb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String> {

    Optional<User> findByName(String name);
}
