package com.example.webserviceMongodb.mapper;

import com.example.webserviceMongodb.domain.User;
import com.example.webserviceMongodb.domain.dto.AuthorRecord;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorRecord toRecord(User user);
}
