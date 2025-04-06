package com.example.webserviceMongodb.domain.dto;

import com.example.webserviceMongodb.domain.User;

import java.time.LocalDate;

public record PostRecord(String id, LocalDate date, String title, String body, User author) {
}
