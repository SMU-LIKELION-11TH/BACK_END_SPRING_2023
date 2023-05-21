package com.test.SpringBootApi.dto;

import com.test.SpringBootApi.domain.NoticeBoard;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NoticeBoardReturnDto {
    private Long id;
    private String title;

    private String content;

    public NoticeBoardReturnDto(NoticeBoard noticBoard) {
        this.id = noticBoard.getId();
        this.title = noticBoard.getTitle();
        this.content = noticBoard.getContent();
    }
}
