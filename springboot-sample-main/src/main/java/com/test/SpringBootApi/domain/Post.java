package com.test.SpringBootApi.domain;

import com.test.SpringBootApi.dto.PostResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public PostResponseDTO toPostResponseDTO(){
        return new PostResponseDTO(
                id = id,
                title = title,
                content = content
        );
    }
}
