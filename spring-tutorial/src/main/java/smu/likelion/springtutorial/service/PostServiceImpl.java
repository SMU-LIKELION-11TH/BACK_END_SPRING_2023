package smu.likelion.springtutorial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smu.likelion.springtutorial.entity.Post;
import smu.likelion.springtutorial.repository.PostRepository;

import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post save(Post post) {
        try{
            return postRepository.save(new Post(post.getId(), post.getTitle(), post.getContents()));
        } catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Optional<Post> findById(Long id) {
        try{
            Optional<Post> post = postRepository.findById(id);
            if(post.isPresent()){
                return post;
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
