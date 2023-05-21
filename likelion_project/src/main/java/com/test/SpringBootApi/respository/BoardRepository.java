package com.test.SpringBootApi.respository;

import com.test.SpringBootApi.domain.BoardEntity;
import com.test.SpringBootApi.dto.BoardDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    BoardEntity save(BoardEntity boardEntity);
    Optional<BoardEntity> findById(Long id);
    List<BoardEntity> findAll();
}
