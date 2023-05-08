package like.lion.blogsample.service;

import like.lion.blogsample.domain.Post;
public interface PostService {

    public Post save(Post post);
    public Post findById(Long id);

}
