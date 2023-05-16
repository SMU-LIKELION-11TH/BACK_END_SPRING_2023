package smu.likelion.springtutorial.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import smu.likelion.springtutorial.domain.Post;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostRequestDto {
    private String boardName;
    private String boardContent;

    public Post toEntity(){
        Post post = new Post(
                this.boardName,
                this.boardContent
        );
        return post;
    }
}
