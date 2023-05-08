package com.example.board.controller;

import com.example.board.domain.Board;
import com.example.board.service.BoardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BoardController {
    @Autowired
    BoardServiceImpl boardService;



    @GetMapping("/posts/{id}")
    public ResponseEntity<Optional<Board>> getBoardById (@PathVariable("id") long id){
        try {
            return ResponseEntity.ok(boardService.findById(id));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/posts")
    public ResponseEntity<Board> createBoard(@RequestBody Board board){
        try {
            ResponseEntity.status(HttpStatus.CREATED).body(boardService.save(board));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @PutMapping("/posts/{id}")
    public ResponseEntity<Board> updateBoard(@PathVariable("id") long id, @RequestBody Board board){
        try {
            ResponseEntity.status(HttpStatus.ACCEPTED).body(boardService.update(id,board));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @DeleteMapping("/posts/{id}")
    public ResponseEntity<HttpStatus> deleteBoard (@PathVariable("id") long id){
        try {
            boardService.delete(id);
            ResponseEntity.noContent();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
