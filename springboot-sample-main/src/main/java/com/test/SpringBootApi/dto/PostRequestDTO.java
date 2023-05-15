package com.test.SpringBootApi.dto;

import com.test.SpringBootApi.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostRequestDTO {
    private String title;
    private String content;

    public PostRequestDTO(Post post){
        this.title = post.getTitle();
        this.content = post.getContent();
    }

    public Post toEntity() {
        return new Post(
                title = title,
                content = content
        );
    }
}
