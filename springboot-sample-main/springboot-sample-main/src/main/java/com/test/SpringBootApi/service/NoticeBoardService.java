package com.test.SpringBootApi.service;

import com.test.SpringBootApi.domain.NoticeBoard;
import com.test.SpringBootApi.dto.NoticeBoardRequestDto;
import com.test.SpringBootApi.dto.NoticeBoardReturnDto;

import java.util.List;
import java.util.Optional;

public interface NoticeBoardService {

    public NoticeBoard save(NoticeBoard board);
//    public Optional<NoticeBoard> findById(Long id);
//    public NoticeBoard update(Long id, NoticeBoard board);
    public Optional<NoticeBoard> findById(Long id);
    public List<NoticeBoardReturnDto> findAll();
    public NoticeBoardReturnDto update(Long id, NoticeBoardRequestDto noticeBoardRequestDto);

    NoticeBoard update(Long id, NoticeBoard board);

    public void delete(Long id);

}
