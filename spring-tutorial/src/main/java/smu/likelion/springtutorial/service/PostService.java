package smu.likelion.springtutorial.service;

import smu.likelion.springtutorial.domain.Post;
import smu.likelion.springtutorial.dto.PostRequestDto;
import smu.likelion.springtutorial.dto.PostReturnDto;

import java.util.Optional;

public interface PostService {

    public Post save(PostRequestDto postRequestDto);

    public PostReturnDto findById(Long id);

    public Post update(Long id, Post post);

    public void delete(Long id);
}
