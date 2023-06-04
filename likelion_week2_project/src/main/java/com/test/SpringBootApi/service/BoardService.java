package com.test.SpringBootApi.service;

import com.test.SpringBootApi.domain.BoardEntity;
import com.test.SpringBootApi.respository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;
    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }
    public BoardEntity addBoard(BoardEntity boardEntity){
        try{
            return boardRepository.save(
                    new BoardEntity(
                            boardEntity.getBoardName(),
                            boardEntity.getContent()

                    )
            );
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public Optional<BoardEntity>findById(Long id){
        try{
            Optional<BoardEntity>boardEntity = boardRepository.findById(id);
            if(boardEntity.isPresent()){
                return boardEntity;
            }
        }catch (Exception e){
            e.printStackTrace();
        }return null;
    }
}
