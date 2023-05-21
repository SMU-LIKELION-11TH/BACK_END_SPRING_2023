package com.test.SpringBootApi.controller;

import com.test.SpringBootApi.dto.NoticeBoardReturnDto;
import com.test.SpringBootApi.service.NoticeBoardServiceImpl;
import com.test.SpringBootApi.domain.NoticeBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class NoticeBoardController {

    @Autowired
    NoticeBoardServiceImpl boardService;

    @GetMapping("/boards/{id}")
    public ResponseEntity<Optional<NoticeBoard>> getNoticeBoardById(@PathVariable("id") long id) {

        try {
            return ResponseEntity.ok(boardService.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    @GetMapping("/boards")
//    public ResponseEntity<Optional<NoticeBoard>> getNoticeBoardByIdQuery(
//            @RequestParam(name= "id") Long id){
//        return ResponseEntity.ok(boardService.findById(id));
//    }

    @GetMapping("/boards")
    public ResponseEntity<List<NoticeBoardReturnDto>> getAllNoticeBoard(){
        List<NoticeBoardReturnDto> noticeBoardReturDtoiList = boardService.findAll();

        return ResponseEntity.ok(noticeBoardReturDtoiList);
    }

    @PostMapping("/boards")
    public ResponseEntity<NoticeBoard> createNoticeBoard(@RequestBody NoticeBoard board) {
        try {
            ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(boardService.save(board));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PutMapping("/boards/{id}")
    public ResponseEntity<NoticeBoard> updateNoticeBoard(
            @PathVariable("id") long id,
            @RequestBody NoticeBoard board
    ) {
        try {
            ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(boardService.update(id, board));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping("/boards/{id}")
    public ResponseEntity<HttpStatus> deleteNoticeBoard(@PathVariable("id") long id) {
        try {
            boardService.delete(id);
            ResponseEntity.noContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
