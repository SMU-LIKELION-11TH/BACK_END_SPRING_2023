package smu.likelion.springtutorial.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import smu.likelion.springtutorial.domain.Post;

@Getter
@Setter
public class PostReturnDto {

    private Long id;

    private String title;

    private String contents;

    public PostReturnDto(Post post){
        this.id = post.getId();
        this.title = post.getTitle();
        this.contents = post.getContents();
    }
}
