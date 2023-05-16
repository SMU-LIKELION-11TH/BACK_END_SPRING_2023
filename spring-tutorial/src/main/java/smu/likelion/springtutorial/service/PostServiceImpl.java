package smu.likelion.springtutorial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smu.likelion.springtutorial.domain.Post;
import smu.likelion.springtutorial.dto.PostRequestDto;
import smu.likelion.springtutorial.dto.PostReturnDto;
import smu.likelion.springtutorial.repository.PostRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service //객체를 생성하도록 등록 -> spring 빈을 등록!
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;
    //게시글 저장
    @Override
    public Post save(PostRequestDto postRequestDto){
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
    //게시글 단건 조회
    @Override
    public PostReturnDto findById(Long id) {
        try{
            Optional<Post> postData = postRepository.findById(id);
            // Optional -> null값을 방지하는 문법
            if(postData.isPresent()){
               return new PostReturnDto(postData.get());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //게시글 전체 조회 -> 일단 추가해봤슴다
    @Override
    public List<PostReturnDto> findAll() {
        List<Post> posts = postRepository.findAll();

        List<PostReturnDto> postReturnDtoList =
                posts.stream().map(post -> new PostReturnDto(post))
                        .collect(Collectors.toList());

        return postReturnDtoList;
    }
    //게시글 수정
    @Override
    public PostReturnDto update(Long id,PostRequestDto postRequestDto){
        try{
            Optional<Post> postData = postRepository.findById(id);
            if(postData.isPresent()){
                Post newPost = postData.get();
                newPost.setBoardName(postRequestDto.getBoardName());
                newPost.setBoardContent(postRequestDto.getBoardContent());
                return new PostReturnDto(newPost);
            }else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    //게시글 삭제
    @Override
    public void delete(Long id){
        try{
            postRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
