package like.lion.blogsample.service;

import like.lion.blogsample.domain.Post;
import like.lion.blogsample.dto.PostRequestDto;
import like.lion.blogsample.dto.PostResponseDto;

public interface PostService {

    public PostResponseDto save(PostRequestDto dto);
    public PostResponseDto findById(Long id);
    public PostResponseDto update(Long id, PostRequestDto dto);

    public void delete(Long id);

}
