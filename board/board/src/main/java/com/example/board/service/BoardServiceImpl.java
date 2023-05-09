package com.example.board.service;

import com.example.board.domain.Board;
import com.example.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    public BoardRepository boardRepository;

    @Override
    public Board save(Board board) {
        try{
            return boardRepository.save(
                new Board(
                    board.getTitle(),
                        board.getWriter()
                )
            );
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Board update(Long id, Board board) {
        try {
            Optional<Board> boardData = boardRepository.findById(id);
            if (boardData.isPresent()){
                Board board1 = boardData.get(); //데이터를 가져오고
                board1.setTitle(board.getTitle());
                board1.setWriter(board.getWriter());
                boardRepository.save(board1);
                return board1;

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Optional<Board> findById(Long id) {
        try{
            Optional<Board> boardData = boardRepository.findById(id);
            if (boardData.isPresent()){
                return boardData;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        try {
            boardRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
