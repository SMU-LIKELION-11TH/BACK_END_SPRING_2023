package com.example.board.dto;

import com.example.board.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BoardReturnDTO {
    private String title;
    private String writer;

    public BoardReturnDTO(Board board) {
        this.title = board.getTitle();
        this.writer = board.getWriter();
    }
}
