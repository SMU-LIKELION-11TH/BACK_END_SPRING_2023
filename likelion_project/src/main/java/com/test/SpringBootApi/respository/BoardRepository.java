package com.test.SpringBootApi.respository;

import com.test.SpringBootApi.domain.BoardEntity;
import com.test.SpringBootApi.dto.BoardDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<BoardDto, Long> {
    BoardDto save(BoardDto boardDto);
    Optional<BoardDto> findById(Long id);
}
