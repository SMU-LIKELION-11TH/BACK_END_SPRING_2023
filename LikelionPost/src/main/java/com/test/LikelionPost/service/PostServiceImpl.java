package com.test.LikelionPost.service;

import com.test.LikelionPost.Dto.PostRequestDto;
import com.test.LikelionPost.Dto.PostReturnDto;
import com.test.LikelionPost.domain.Post;
import com.test.LikelionPost.repository.PostRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Override
    public Post save(PostRequestDto postRequestDto) {
        try{
            return postRepository
                    .save(
                            postRequestDto.toEntity()
                    );
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PostReturnDto findById(Long id) {
        try{
            Optional<Post> postData=postRepository.findById(id);
            if(postData.isPresent()){
                return new PostReturnDto(postData.get());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<PostReturnDto> findAll(){
        List<Post> posts = postRepository.findAll();
        List<PostReturnDto> postReturnDtoList = posts.stream().map(post -> new PostReturnDto(post)).collect(Collectors.toList());
        return postReturnDtoList;

    }
    @Transactional
    @Override
    public PostReturnDto update(Long id, PostRequestDto postRequestDto){
        try{
            Optional <Post> postData = postRepository.findById(id);
            if(postData.isPresent()){
                Post _post = postData.get();
                _post.setTitle(postRequestDto.getTitle());
                _post.setContents(postRequestDto.getContent());
                return new PostReturnDto(_post);
            }else{
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public void delete(Long id) {
        try{
            postRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

