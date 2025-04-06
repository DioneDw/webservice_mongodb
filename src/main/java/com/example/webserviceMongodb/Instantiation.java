package com.example.webserviceMongodb;

import com.example.webserviceMongodb.domain.Post;
import com.example.webserviceMongodb.domain.User;
import com.example.webserviceMongodb.domain.dto.AuthorRecord;
import com.example.webserviceMongodb.domain.dto.CommentRecord;
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
        userRepository.save(u1);
        userRepository.save(u2);
        userRepository.save(u3);


        Post post1 = new Post(null, LocalDate.parse("01/05/2025",dtf), "Partiu Viagem","Vou viajar para Porto Seguro", AuthorRecord.fromUser(u1));
        Post post2 = new Post(null, LocalDate.parse("02/05/2025",dtf), "Terminal lotado","Esperando para embarcar, fuiii!!!", AuthorRecord.fromUser(u1));

        CommentRecord c1 = new CommentRecord("Que legal, boa viagem!",LocalDate.parse("02/05/2025",dtf),AuthorRecord.fromUser(u3));
        CommentRecord c2 = new CommentRecord("Vai ir de onibus ou avião Maria?",LocalDate.parse("01/05/2025",dtf),AuthorRecord.fromUser(u2));
        CommentRecord c3 = new CommentRecord("Tenso!!",LocalDate.parse("03/05/2025",dtf),AuthorRecord.fromUser(u2));

        post1.getComments().addAll(List.of(c1,c2));
        post2.getComments().add(c3);

        postRepository.saveAll(List.of(post1,post2));

        u1.getPosts().addAll(List.of(post1,post2));
        userRepository.save(u1);
    }
}
