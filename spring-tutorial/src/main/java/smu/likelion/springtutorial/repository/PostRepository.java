package smu.likelion.springtutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import smu.likelion.springtutorial.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
