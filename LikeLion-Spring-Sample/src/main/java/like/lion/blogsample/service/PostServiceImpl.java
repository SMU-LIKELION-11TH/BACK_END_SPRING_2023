package like.lion.blogsample.service;

import like.lion.blogsample.domain.Post;
import like.lion.blogsample.dto.PostRequestDto;
import like.lion.blogsample.dto.PostResponseDto;
import like.lion.blogsample.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    @Override
    public PostResponseDto save(PostRequestDto dto) {
        try {
            return new PostResponseDto(postRepository.save(dto.toEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PostResponseDto findById(Long id) {
        try {
            Optional<Post> post = postRepository.findById(id);
            if (post.isPresent()) {
                return new PostResponseDto(post.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public PostResponseDto update(Long id, PostRequestDto dto) {
        try {
            Optional<Post> post = postRepository.findById(id);
            if (post.isPresent()) {
                Post _post = post.get();
                _post.update(dto.getTitle(), dto.getContent());
                return new PostResponseDto(_post);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void delete(Long id) {
        try {
            postRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
