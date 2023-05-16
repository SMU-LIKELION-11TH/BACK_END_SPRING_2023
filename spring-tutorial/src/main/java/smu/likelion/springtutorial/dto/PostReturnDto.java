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
public class PostReturnDto {
    private Long id;
    private String boardName;
    private String boardContent;

    public PostReturnDto(Post post){
        this.id = post.getId();
        this.boardName = post.getBoardName();
        this.boardContent = post.getBoardName();
    }
}
