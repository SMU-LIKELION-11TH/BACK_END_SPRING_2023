package like.lion.blogsample.Dto;

import like.lion.blogsample.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
public class PostRequestDto {
    private String title;
    private String content;

    public Post toEntity(){
        Post post= new Post(this.title,this.content);
        return post;
    }

}
