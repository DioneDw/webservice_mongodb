package com.example.webserviceMongodb.service;

import com.example.webserviceMongodb.domain.Post;
import com.example.webserviceMongodb.domain.dto.PostRecord;
import com.example.webserviceMongodb.mapper.PostMapper;
import com.example.webserviceMongodb.mapper.UserMapper;
import com.example.webserviceMongodb.repository.PostRepository;
import com.example.webserviceMongodb.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PostMapper postMapper;



    public PostRecord findById(String id){
        Post post = repository.findById(id).orElseThrow(ObjectNotFoundException::new);
        return postMapper.toRecord(post);
    }

}
