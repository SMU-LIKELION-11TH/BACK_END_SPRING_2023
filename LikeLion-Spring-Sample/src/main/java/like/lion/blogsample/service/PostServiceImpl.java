package like.lion.blogsample.service;

import like.lion.blogsample.domain.Post;
import like.lion.blogsample.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    @Override
    public Post save(Post post) {
        try {
            return postRepository.save(post);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Post findById(Long id) {
        try {
            Optional<Post> post = postRepository.findById(id);
            if (post.isPresent()) {
                return post.get();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
