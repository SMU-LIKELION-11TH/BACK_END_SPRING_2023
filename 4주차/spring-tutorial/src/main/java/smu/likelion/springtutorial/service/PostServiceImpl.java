package smu.likelion.springtutorial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smu.likelion.springtutorial.dto.Post;
import smu.likelion.springtutorial.repository.PostRepository;

import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    private PostRepository postRepository;

    @Override
    public Post save(Post product) {
        try {
            return postRepository
                    .save(
                            new Post(
                                    product.getPost_id(),
                                    product.getUser_id(),
                                    product.getTitle(),
                                    product.getContent()
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
            Optional<Post> productData = postRepository.findById(id);
            if (productData.isPresent()) {
                return productData;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Post update(Long id, Post product) {

        try {
            Optional<Post> postData = postRepository.findById(id);
            if (postData.isPresent()) {
                Post _post = postData.get();
                _post.setPost_id(product.getPost_id());
                _post.setUser_id(product.getUser_id());
                _post.setTitle(product.getTitle());
                _post.setContent(product.getTitle());
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
}
