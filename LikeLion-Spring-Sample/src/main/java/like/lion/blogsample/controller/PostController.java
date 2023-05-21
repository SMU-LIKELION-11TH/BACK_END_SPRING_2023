package like.lion.blogsample.controller;

import like.lion.blogsample.dto.PostRequestDto;
import like.lion.blogsample.dto.PostResponseDto;
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
    public PostResponseDto getPostById(@PathVariable long id) {
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
    public PostResponseDto createPost(@RequestBody PostRequestDto post) {
        try {
            return postService.save(post);
        } catch (Exception e) {
            e.printStackTrace();;
        }

        return null;
    }
    /**
     *  PUT : 게시글 수정
     */
    @PutMapping("/posts/{id}")
    public PostResponseDto updatePost(@PathVariable Long id, @RequestBody PostRequestDto post) {
        try {
            return postService.update(id, post);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * DELETE :  게시글 삭제
     */

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable Long id) {
        try {
            postService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
