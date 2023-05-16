package smu.likelion.springtutorial.service;


import smu.likelion.springtutorial.domain.Post;
import smu.likelion.springtutorial.dto.PostRequestDto;
import smu.likelion.springtutorial.dto.PostReturnDto;

import java.util.*;

public interface PostService {

    public Post save(PostRequestDto postRequestDto);
    public PostReturnDto findById(Long id);
    public List<PostReturnDto> findAll();
    public PostReturnDto update(Long id,PostRequestDto postRequestDto);
    public  void delete(Long id);
}
