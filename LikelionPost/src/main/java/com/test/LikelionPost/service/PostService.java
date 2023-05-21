package com.test.LikelionPost.service;

import com.test.LikelionPost.Dto.PostRequestDto;
import com.test.LikelionPost.Dto.PostReturnDto;
import com.test.LikelionPost.domain.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    public Post save(PostRequestDto postRequestDto);
    public PostReturnDto findById(Long id);
    public List<PostReturnDto> findAll();
    public PostReturnDto update(Long id,PostRequestDto postRequestDto);
    public void delete(Long id);
}
