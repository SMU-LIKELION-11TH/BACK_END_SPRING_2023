package com.test.SpringBootApi.service;

import com.test.SpringBootApi.domain.Post;

import java.util.Optional;

public interface PostService {
    public Post save(Post post);
    public Optional<Post> findById(Long id);
}
