package com.test.SpringBootApi.controller;

import com.test.SpringBootApi.service.PostServiceImpl;
import com.test.SpringBootApi.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    PostServiceImpl postService;

    @GetMapping("/posts/{id}")
    public ResponseEntity<Optional<Post>> getPostById(@PathVariable("id") long id) {

        try {
            return ResponseEntity.ok(postService.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        System.out.println(post.getTitle());
        try {
            ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(postService.save(post));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
