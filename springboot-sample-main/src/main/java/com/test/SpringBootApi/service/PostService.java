package com.test.SpringBootApi.service;

import com.test.SpringBootApi.domain.Post;
import com.test.SpringBootApi.dto.PostRequestDTO;
import com.test.SpringBootApi.dto.PostResponseDTO;

import java.util.Optional;

public interface PostService {
    public PostResponseDTO save(PostRequestDTO postRequestDTO);
    public PostResponseDTO findById(Long id);
    public PostResponseDTO update(Long id, PostRequestDTO postRequestDTO);
    public void delete(Long id);
}
