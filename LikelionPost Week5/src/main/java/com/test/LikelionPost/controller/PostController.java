package com.test.LikelionPost.controller;

import com.test.LikelionPost.domain.Post;
import com.test.LikelionPost.service.PostServiceImpl;
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

        try{
            return ResponseEntity.ok(postService.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @PostMapping("/posts")
    public ResponseEntity<Post> createProduct(@RequestBody Post post) {
        try {
            ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(postService.save(post));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> updateProduct(
            @PathVariable("id") long id,
            @RequestBody Post post
    ) {
        try {
            ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(postService.update(id, post));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") long id) {

        try{
            postService.delete(id);
            ResponseEntity.noContent();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
