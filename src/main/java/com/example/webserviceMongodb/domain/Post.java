package com.example.webserviceMongodb.domain;

import com.example.webserviceMongodb.domain.dto.AuthorRecord;
import com.example.webserviceMongodb.domain.dto.CommentRecord;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Document
public class Post {

    @Id
    private String id;
    private LocalDate date;
    private String title;
    private String body;

    private AuthorRecord author;

    private List<CommentRecord> comments = new ArrayList<>();

    public Post(String id, LocalDate date, String title, String body, AuthorRecord author) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }
}
