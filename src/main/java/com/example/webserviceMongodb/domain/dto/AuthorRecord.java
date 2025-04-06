package com.example.webserviceMongodb.domain.dto;

import com.example.webserviceMongodb.domain.User;

public record AuthorRecord(String id, String name) {
    public static AuthorRecord fromUser(User user) {
        return new AuthorRecord(user.getId(), user.getName());
    }
}
