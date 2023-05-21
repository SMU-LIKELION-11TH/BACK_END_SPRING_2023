package com.test.LikelionPost.Dto;

import com.test.LikelionPost.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostReturnDto {
    private long id;
    private String title;
    private String content;
    public PostReturnDto(Post post){
        this.id=post.getId();
        this.title=post.getTitle();
        this.content=post.getContents();
    }

}
