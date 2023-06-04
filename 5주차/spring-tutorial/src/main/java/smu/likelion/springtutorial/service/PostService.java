package smu.likelion.springtutorial.service;

import smu.likelion.springtutorial.domain.Post;
import smu.likelion.springtutorial.dto.PostReturnDto;

import java.util.List;
import java.util.Optional;

public interface PostService {
    public Post save(Post post);
    public PostReturnDto findById(Long id);
    public Post update(Long id, Post post);
    public void delete(Long id);

    public List<PostReturnDto> findAll();
}
