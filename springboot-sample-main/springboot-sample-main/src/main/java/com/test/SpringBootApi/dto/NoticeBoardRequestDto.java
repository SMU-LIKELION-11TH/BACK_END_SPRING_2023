package com.test.SpringBootApi.dto;

import com.test.SpringBootApi.domain.NoticeBoard;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class NoticeBoardRequestDto {
    private String title;
    private String content;

    public NoticeBoard toEntity(){
        NoticeBoard noticeBoard = new NoticeBoard(
                this.title,
                this.content
        );
        return noticeBoard;
    }
}
