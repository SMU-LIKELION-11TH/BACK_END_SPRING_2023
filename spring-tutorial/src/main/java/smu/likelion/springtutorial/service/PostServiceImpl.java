package smu.likelion.springtutorial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smu.likelion.springtutorial.domain.Post;
import smu.likelion.springtutorial.repository.PostRepository;

import java.util.List;
import java.util.Optional;

@Service //객체를 생성하도록 등록 -> spring 빈을 등록!
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post save(Post post){
        try{
            return postRepository.save(post);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Post findById(Long id) {
        try{
            Optional<Post> postData = postRepository.findById(id);
            // Optional -> null값을 방지하는 문법
            if(postData.isPresent()){
               return postData.get();
               // 여기 잘 모르겟숨
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    @Override
//    public List<Post> findAll() {
//        List<Post> posts = postRepository.findAll();
//
//        List<Post> postList =
//                posts.stream().map(post -> new Post(postData))
//
//        return null;
//    }
}
