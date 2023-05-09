package like.lion.blogsample.controller;

import like.lion.blogsample.domain.Post;
import like.lion.blogsample.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    /**
     *  GET : 게시글 단건 조회
     */
    @GetMapping("/posts/{id}")
    public Post getPostById(@PathVariable long id) {
        try {
            return postService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *   POST : 게시글 생성
     */
    @PostMapping("/posts")
    public Post createPost(@RequestBody Post post) {
        try {
            return postService.save(post);
        } catch (Exception e) {
            e.printStackTrace();;
        }

        return null;
    }
}
