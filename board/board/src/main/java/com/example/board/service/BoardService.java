package com.example.board.service;

import com.example.board.domain.Board;

import java.util.Optional;

public interface BoardService {

    public Board save(Board board);
    public Board update(Long id, Board board);
    public Optional<Board> findById(Long id);
    public void delete(Long id);
}
