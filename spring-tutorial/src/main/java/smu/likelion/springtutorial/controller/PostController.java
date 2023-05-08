package smu.likelion.springtutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smu.likelion.springtutorial.entity.Post;
import smu.likelion.springtutorial.service.PostServiceImpl;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    PostServiceImpl postService;

    @PostMapping("/posts/create")
    public ResponseEntity<Post> createPost(@RequestBody Post post){
        try{
            ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(postService.save(post));
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Optional<Post>> getPostById(@PathVariable("id") long id) {
        try{
            return ResponseEntity.ok(postService.findById(id));
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
