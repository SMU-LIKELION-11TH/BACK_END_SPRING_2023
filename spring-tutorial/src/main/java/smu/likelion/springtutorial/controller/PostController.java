package smu.likelion.springtutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smu.likelion.springtutorial.domain.Post;
import smu.likelion.springtutorial.dto.PostRequestDto;
import smu.likelion.springtutorial.dto.PostReturnDto;
import smu.likelion.springtutorial.service.PostServiceImpl;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    PostServiceImpl postService;

    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(@RequestBody PostRequestDto postRequestDto){
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(postService.save(postRequestDto));
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<PostReturnDto> getPostById(@PathVariable("id") long id) {
        try{
            return ResponseEntity.ok(postService.findById(id));
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable("id") long id, @RequestBody Post post){

        try{
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(postService.update(id, post));
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<HttpStatus> deletePost(@PathVariable("id") long id) {
        try{
            postService.delete(id);
            ResponseEntity.noContent();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
