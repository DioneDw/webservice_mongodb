package com.example.webserviceMongodb.mapper;

import com.example.webserviceMongodb.domain.Post;
import com.example.webserviceMongodb.domain.dto.PostRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {


    Post toEntity(PostRecord postRecord);

    @Mapping(source="author", target = "authorRecord")
    PostRecord toRecord(Post post);

    @Mapping(source="author", target = "authorRecord")
    List<PostRecord> toRecordList(List<Post> posts);
}
