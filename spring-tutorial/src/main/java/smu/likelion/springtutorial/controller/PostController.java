package smu.likelion.springtutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import smu.likelion.springtutorial.domain.Post;
import smu.likelion.springtutorial.service.PostService;
import smu.likelion.springtutorial.service.PostServiceImpl;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;


    @PostMapping("/posts")
    public Post createPost(@RequestBody Post post){
        try {
            return postService.save(post);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @GetMapping("/posts/{id}")
    public Post BoardDetail(@PathVariable("id") long id){
        try {
            Post postDetails = postService.findById(id);
            return postDetails;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}


