package like.lion.blogsample.dto;

import like.lion.blogsample.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostRequestDto {
    private String title;
    private String content;

    public Post toEntity() {
        return new Post(this.title, this.content);
    }
}
