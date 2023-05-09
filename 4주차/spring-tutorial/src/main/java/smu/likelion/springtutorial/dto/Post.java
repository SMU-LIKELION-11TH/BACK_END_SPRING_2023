package smu.likelion.springtutorial.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "posts")
public class Post {
    //PK
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long post_id;

    //User id
    @Column(name = "user_id")
    private Long user_id;
    //Post title
    private String title;
    //Post contents
    private String content;

    public Post(Long post_id, Long user_id, String title, String content) {
        this.post_id = post_id;
        this.user_id = user_id;
        this.title = title;
        this.content = content;
    }

}
