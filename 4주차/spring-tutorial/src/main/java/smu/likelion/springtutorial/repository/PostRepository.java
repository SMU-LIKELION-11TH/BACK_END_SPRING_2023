package smu.likelion.springtutorial.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import smu.likelion.springtutorial.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
