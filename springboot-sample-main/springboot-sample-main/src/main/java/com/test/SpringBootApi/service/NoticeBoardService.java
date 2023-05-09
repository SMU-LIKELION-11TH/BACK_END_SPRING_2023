package com.test.SpringBootApi.service;

import com.test.SpringBootApi.domain.NoticeBoard;

import java.util.Optional;

public interface NoticeBoardService {

    public NoticeBoard save(NoticeBoard board);
    public Optional<NoticeBoard> findById(Long id);
    public NoticeBoard update(Long id, NoticeBoard board);
    public void delete(Long id);

}
