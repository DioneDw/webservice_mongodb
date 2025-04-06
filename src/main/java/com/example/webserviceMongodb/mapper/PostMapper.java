package com.example.webserviceMongodb.mapper;

import com.example.webserviceMongodb.domain.Post;
import com.example.webserviceMongodb.domain.dto.PostRecord;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {


    Post toEntity(PostRecord postRecord);

    PostRecord toRecord(Post post);

    List<PostRecord> toRecordList(List<Post> posts);
}
