package like.lion.blogsample.repository;
import like.lion.blogsample.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PostRepository extends JpaRepository<Post, Long> {
}

