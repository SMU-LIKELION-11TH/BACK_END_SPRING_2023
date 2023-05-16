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
    public BoardDto addBoard(BoardDto boardDto){
        try{
            return boardRepository.save(boardDto);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public Optional<BoardDto>findById(Long id){
        try{
            Optional<BoardDto>boardDto = boardRepository.findById(id);
            if(boardDto.isPresent()){
                return boardDto;
            }
        }catch (Exception e){
            e.printStackTrace();
        }return null;
    }
}
