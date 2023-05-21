package smu.likelion.springtutorial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smu.likelion.springtutorial.domain.Post;
import smu.likelion.springtutorial.dto.PostReturnDto;
import smu.likelion.springtutorial.dto.PostSaveDto;
import smu.likelion.springtutorial.repository.PostRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    private PostRepository postRepository;

    @Override
    public Post save(Post post) {
        try {
            return postRepository.save(post);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public PostReturnDto findById(Long id) {
        try {
            Optional<Post> postData = postRepository.findById(id);
            if (postData.isPresent()) {
                Post post = postData.get();
                PostReturnDto postReturnDto = new PostReturnDto(post);
                return postReturnDto;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Post update(Long id, Post post) {

        try {
            Optional<Post> postData = postRepository.findById(id);
            if (postData.isPresent()) {
                Post _post = postData.get();
                _post.setPost_id(post.getPost_id());
                _post.setUser_id(post.getUser_id());
                _post.setTitle(post.getTitle());
                _post.setContent(post.getTitle());
                postRepository.save(_post);
                return _post;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void delete(Long id) {
        try {
            postRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<PostReturnDto> findAll() {
        List<Post> postList = postRepository.findAll();
        return postList.stream().map(PostReturnDto::new).collect(Collectors.toList());
    }
}
