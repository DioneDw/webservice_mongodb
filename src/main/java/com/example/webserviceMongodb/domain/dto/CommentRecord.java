package com.example.webserviceMongodb.domain.dto;

import java.time.LocalDate;

public record CommentRecord(String text, LocalDate date, AuthorRecord author) {
}
