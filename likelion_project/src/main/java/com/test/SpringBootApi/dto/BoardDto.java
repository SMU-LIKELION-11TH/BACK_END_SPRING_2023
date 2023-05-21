package com.test.SpringBootApi.dto;

import com.test.SpringBootApi.domain.BoardEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
    private Long id;

    private String title;

    private String content;

    public BoardDto(BoardEntity boardEntity){
        this.id = id;
        this.title = title;
        this.content = content;
    }
    public BoardEntity ToEntity(){
        return new BoardEntity(this.id, this.title, this.content);
    }
}
