package smu.likelion.springtutorial.service;

import org.springframework.http.ResponseEntity;
import smu.likelion.springtutorial.dto.Post;

import java.util.Optional;

public interface PostService {
    public Post save(Post post);
    public Optional<Post> findById(Long id);
    public Post update(Long id, Post post);
    public void delete(Long id);
}
