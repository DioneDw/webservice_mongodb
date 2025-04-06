package com.example.webserviceMongodb.domain.dto;

import java.time.LocalDate;
import java.util.List;

public record PostRecord(String id, LocalDate date, String title, String body, AuthorRecord authorRecord, List<CommentRecord> comments) {
}
