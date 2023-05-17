package smu.likelion.springtutorial.dto;

import lombok.*;
import smu.likelion.springtutorial.domain.Post;

import java.sql.Timestamp;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostSaveDto {
    private Long post_id;

    private Long user_id;


    private String title;


    private String content;


    private Timestamp created_at;


    private Timestamp updated_at;

    private int status;

    public PostSaveDto(Post post) {
        this.post_id = post.getPost_id();
        this.user_id = post.getUser_id();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.created_at = post.getCreated_at();
        this.updated_at = post.getUpdated_at();
        this.status = post.getStatus();
    }
}
