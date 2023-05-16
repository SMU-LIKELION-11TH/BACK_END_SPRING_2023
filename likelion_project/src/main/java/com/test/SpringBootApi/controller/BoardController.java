package com.test.SpringBootApi.controller;

import com.test.SpringBootApi.domain.BoardEntity;
import com.test.SpringBootApi.dto.BoardDto;
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
    public ResponseEntity<BoardDto> addBoard(@RequestBody BoardDto boardDto){
        try{
            ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(boardService.addBoard(boardDto));
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @GetMapping("/posts/")
    public ResponseEntity<Optional<BoardDto>> findById(@RequestParam(name="id") Long id){
        return ResponseEntity.ok(boardService.findById(id));
    }


}
