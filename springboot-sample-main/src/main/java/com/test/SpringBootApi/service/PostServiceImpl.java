package com.test.SpringBootApi.service;

import com.test.SpringBootApi.domain.Post;
import com.test.SpringBootApi.dto.PostRequestDTO;
import com.test.SpringBootApi.dto.PostResponseDTO;
import com.test.SpringBootApi.respository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public PostResponseDTO save(PostRequestDTO postRequestDTO) {
        try {
            return postRepository.save(postRequestDTO.toEntity()).toPostResponseDTO();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PostResponseDTO findById(Long id) {
        try {
            Optional<Post> postData = postRepository.findById(id);
            if (postData.isPresent()) {
                return postData.get().toPostResponseDTO();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PostResponseDTO update(Long id, PostRequestDTO postRequestDTO) {
        postRepository.findAll();
        try {
            Optional<Post> postData = postRepository.findById(id);
            if (postData.isPresent()) {
                Post _post = postData.get();
                _post.setTitle(postRequestDTO.getTitle());
                _post.setContent(postRequestDTO.getContent());
                postRepository.save(_post);
                return _post.toPostResponseDTO();
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
}
