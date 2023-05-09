package smu.likelion.springtutorial.service;

import smu.likelion.springtutorial.entity.Post;

import java.util.Optional;

public interface PostService {

    public Post save(Post post);

    public Optional<Post> findById(Long id);
}
