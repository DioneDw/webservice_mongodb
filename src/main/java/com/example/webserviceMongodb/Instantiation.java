package com.example.webserviceMongodb;

import com.example.webserviceMongodb.domain.User;
import com.example.webserviceMongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        User u1 = new User(null, "Maria","maria@gmail.com");
        User u2 = new User(null, "Alex Gray","alex@gmail.com");
        User u3 = new User(null, "Bob Gray","bob@gmail.com");

        repository.saveAll(List.of(u1,u2,u3));

    }
}
