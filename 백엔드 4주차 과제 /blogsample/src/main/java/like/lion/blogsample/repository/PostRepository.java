package like.lion.blogsample.repository;

import like.lion.blogsample.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//레포지토리는 인터페이스로 정의
//JpaRepository 를 상속 받야아함
@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

}
