package com.test.LikelionPost.service;

import com.test.LikelionPost.domain.Post;
import com.test.LikelionPost.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post save(Post post) {
        try {
            return postRepository.save(
                    new Post(
                            post.getTitle(),
                            post.getContents()
                    )
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Optional<Post> findById(Long id) {
        try{
            Optional<Post> postData = postRepository.findById(id);
            if (postData.isPresent()) {
                return postData;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Post update(Long id, Post post) {
        try{
            Optional<Post> postData = postRepository.findById(id);
            if (postData.isPresent()) {
                Post _post = postData.get();
                _post.setTitle(post.getTitle());
                _post.setContents(post.getContents());
                postRepository.save(_post);
                return _post;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void delete(Long id) {
        try{
            postRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
