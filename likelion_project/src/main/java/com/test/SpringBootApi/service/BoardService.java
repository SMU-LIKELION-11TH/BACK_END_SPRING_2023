package com.test.SpringBootApi.service;

import com.test.SpringBootApi.domain.BoardEntity;
import com.test.SpringBootApi.dto.BoardDto;
import com.test.SpringBootApi.respository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class BoardService {
    @Autowired
    private BoardRepository boardRepository;
    public BoardEntity addBoard(BoardDto boardDto){
        try{
           return boardRepository.save(boardDto.ToEntity());
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public Object findById(Long id){
        try{
            Optional<BoardEntity> boardEntity = boardRepository.findById(id);
            if(boardEntity.isPresent()){
                return boardEntity.get().getId();
            }
        }catch (Exception e){
            e.printStackTrace();
        }return null;
    }

    public Object deleteBoard(long id){
        Optional<BoardEntity>boardEntity = boardRepository.findById(id);
        try{
            boardRepository.delete(boardEntity.get());
            return boardEntity.get().getId();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public Object updateBoard(long id, BoardDto boardDto){
        Optional<BoardEntity> boardEntity = boardRepository.findById(id);
        if(boardEntity.isPresent()){
            BoardEntity boardEntity1 = boardEntity.get();
            boardEntity1.setTitle(boardDto.getTitle());
            boardEntity1.setBoardName(boardDto.getContent());
            BoardEntity updateEntity = boardRepository.save(boardEntity1);
            return new BoardDto(updateEntity);
        }
        return null;
    }
}
