package smu.likelion.springtutorial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smu.likelion.springtutorial.domain.Post;
import smu.likelion.springtutorial.dto.PostRequestDto;
import smu.likelion.springtutorial.dto.PostReturnDto;
import smu.likelion.springtutorial.repository.PostRepository;

import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post save(PostRequestDto postRequestDto) {
        try{
            return postRepository.save(new Post(postRequestDto.getTitle(), postRequestDto.getContents()));
        } catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public PostReturnDto findById(Long id) {
        try{
            Optional<Post> postData = postRepository.findById(id);
            if(postData.isPresent()){
                Post post = postData.get();
                PostReturnDto postReturnDto = new PostReturnDto(post);
                return postReturnDto;
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Post update(Long id, Post post){

        try{
            Optional<Post> postData = postRepository.findById(id);
            if(postData.isPresent()){
                Post _post = postData.get();
                _post.setTitle(post.getTitle());
                _post.setContents(post.getContents());
                postRepository.save(_post);
                return _post;
            } else{
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void delete(Long id){
        try{
            postRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
