package com.test.SpringBootApi.service;

import com.test.SpringBootApi.domain.Post;
import com.test.SpringBootApi.respository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post save(Post post) {
        try {
            return postRepository
                    .save(
                    new Post(
                            post.getTitle(),
                            post.getContent()
                    )
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Optional<Post> findById(Long id) {
        try {
            Optional<Post> postData = postRepository.findById(id);
            if (postData.isPresent()) {
                return postData;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
