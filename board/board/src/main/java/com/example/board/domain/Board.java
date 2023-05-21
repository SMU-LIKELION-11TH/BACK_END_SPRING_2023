package com.example.board.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="boards")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "writer")
    private String writer;
    Board() {}

    public Board(String title, String writer){
        this.title = title;
        this.writer = writer;
    }

}
