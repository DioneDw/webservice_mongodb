package com.example.webserviceMongodb.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record UserRecord(String id, @NotBlank String name, @Email String email, List<PostRecord> posts) {
}
