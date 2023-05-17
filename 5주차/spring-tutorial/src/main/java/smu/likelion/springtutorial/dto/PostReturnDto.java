package smu.likelion.springtutorial.dto;

import lombok.*;

import java.util.List;

@Data // 웬만한 Getter, Setter, 생성자
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostReturnDto {

    private Long post_id;

    private Long user_id;

    private String title;

    private String content;

}
