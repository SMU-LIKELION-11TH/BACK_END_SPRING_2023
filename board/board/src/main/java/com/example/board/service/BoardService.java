package com.example.board.service;

import com.example.board.domain.Board;
import com.example.board.dto.BoardReturnDTO;

public interface BoardService {

    public Board save(Board board);
    public Board update(Long id, Board board);
    public BoardReturnDTO findById(Long id);
    public void delete(Long id);
}
