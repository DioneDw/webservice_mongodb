package com.example.webserviceMongodb;

import com.example.webserviceMongodb.domain.Post;
import com.example.webserviceMongodb.domain.User;
import com.example.webserviceMongodb.domain.dto.AuthorRecord;
import com.example.webserviceMongodb.repository.PostRepository;
import com.example.webserviceMongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User u1 = new User(null, "Maria","maria@gmail.com");
        User u2 = new User(null, "Alex Gray","alex@gmail.com");
        User u3 = new User(null, "Bob Gray","bob@gmail.com");
        userRepository.saveAll(List.of(u1,u2,u3));

        Post post1 = new Post(null, LocalDate.parse("01/05/2025",dtf), "Partiu Viagem","Vou viajar para Porto Seguro", new AuthorRecord(u1.getId(),u1.getName()));
        Post post2 = new Post(null, LocalDate.parse("02/05/2025",dtf), "Terminal lotado","Esperando para embarcar, fuiii!!!", new AuthorRecord(u1.getId(),u1.getName()))    ;
        postRepository.saveAll(List.of(post1,post2));

        u1.getPosts().addAll(List.of(post1,post2));
        userRepository.save(u1);
    }
}
