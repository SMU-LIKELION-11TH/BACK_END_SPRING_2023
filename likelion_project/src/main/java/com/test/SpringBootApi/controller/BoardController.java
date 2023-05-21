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
    @GetMapping("/posts/findBoard/{id}")
    public ResponseEntity<?> findById(@RequestParam(name="id") Long id){
        Optional<BoardDto>boardDto = (Optional<BoardDto>) boardService.findById(id);
        if(boardDto.isPresent()){
            return ResponseEntity.ok().body(boardDto.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("posts/deleteBoard{id}")
    public ResponseEntity<?> deleteBoard(@PathVariable("id")long id){
        try{
            boardService.deleteBoard(id);
            ResponseEntity.ok();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @PutMapping("posts/updateBoard/{id}")
    public ResponseEntity<BoardDto> updateBoard(@PathVariable long id, @RequestBody BoardDto boardDto){
        BoardDto updateBoard = (BoardDto) boardService.updateBoard(id,boardDto);
        if(updateBoard!=null){
            return ResponseEntity.ok().body(updateBoard);
        }
        return ResponseEntity.notFound().build();
    }
}
