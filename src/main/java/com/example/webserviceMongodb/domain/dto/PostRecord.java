package com.example.webserviceMongodb.domain.dto;

import java.time.LocalDate;

public record PostRecord(String id, LocalDate date, String title, String body, AuthorRecord authorRecord) {
}
