package com.example.webserviceMongodb.mapper;

import com.example.webserviceMongodb.domain.User;
import com.example.webserviceMongodb.domain.dto.UserRecord;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserRecord record);
    UserRecord toRecord(User entity);
}
