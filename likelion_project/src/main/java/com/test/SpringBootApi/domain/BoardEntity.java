package com.test.SpringBootApi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@Data
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String title;
    @Column
    private String content;
    public BoardEntity(){}
    public BoardEntity(String title, String content){
        this.title = title;
        this.content = content;
    }
    public long getId(){
        return id;
    }
    public void setId(Long id){this.id = id;}
    public String getBoardName() {
        return title;
    }

    public void setBoardName(String productName) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContetn(int price) {
        this.content = content;
    }

}
