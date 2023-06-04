package com.test.SpringBootApi.controller;

import com.test.SpringBootApi.domain.BoardEntity;
import com.test.SpringBootApi.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BoardController {
    @Autowired
    private BoardService boardService;
    @PostMapping("/posts/")
    public ResponseEntity<BoardEntity> addBoard(@RequestBody BoardEntity boardEntity){
        try{
            ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(boardService.addBoard(boardEntity));
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @GetMapping("/posts/")
    public ResponseEntity<Optional<BoardEntity>> findById(@RequestParam(name="id") Long id){
        return ResponseEntity.ok(boardService.findById(id));
    }


}
