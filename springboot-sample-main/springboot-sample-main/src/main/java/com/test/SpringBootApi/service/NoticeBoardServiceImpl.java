package com.test.SpringBootApi.service;

import com.test.SpringBootApi.domain.NoticeBoard;
import com.test.SpringBootApi.respository.NoticeBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NoticeBoardServiceImpl implements NoticeBoardService {

    @Autowired
    private NoticeBoardRepository boardRepository;

    @Override
    public NoticeBoard save(NoticeBoard board) {
        try {
            return boardRepository
                    .save(
                    new NoticeBoard(
                            board.getTitle(),
                            board.getContent()
                    )
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Optional<NoticeBoard> findById(Long id) {
        try {
            Optional<NoticeBoard> noticeBoardData = boardRepository.findById(id);
            if (noticeBoardData.isPresent()) {
                return noticeBoardData;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public NoticeBoard update(Long id, NoticeBoard board) {

        try {
            Optional<NoticeBoard> noticeBoardData = boardRepository.findById(id);
            if (noticeBoardData.isPresent()) {
                NoticeBoard _board = noticeBoardData.get();
                _board.setTitle(board.getTitle());
                _board.setContent(board.getContent());
                boardRepository.save(_board);
                return _board;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void delete(Long id) {
        try {
            boardRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
