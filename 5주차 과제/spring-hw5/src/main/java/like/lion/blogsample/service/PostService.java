package like.lion.blogsample.service;

import like.lion.blogsample.Dto.PostReturnDto;
import like.lion.blogsample.domain.Post;
import like.lion.blogsample.Dto.PostRequestDto;

import java.util.List;
import java.util.Optional;

//PostService 에서 필요한 메서드를 정의 (CRUD = 작성, 조회 (단건 조회 / 목록 조회) , 수정, 삭제)
//이번 과제에서는 작성과 조회만 구현
public interface PostService {
    public Post save(PostRequestDto postRequestDto);
    public PostReturnDto findById(Long id);
    public List<PostReturnDto> findAll();
    public PostReturnDto update(Long id,PostRequestDto postRequestDto);
    public void delete(Long id);
}
