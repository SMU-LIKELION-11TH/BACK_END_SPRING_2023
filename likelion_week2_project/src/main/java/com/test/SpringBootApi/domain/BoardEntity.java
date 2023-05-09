package com.test.SpringBootApi.domain;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import javax.persistence.*;

@Entity
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
    public Long getId(){return id;}
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
