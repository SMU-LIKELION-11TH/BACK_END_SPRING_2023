package smu.likelion.springtutorial.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name="boards")
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "contents")
    private String contents;

    public Post(String title, String contents){
        this.title = title;
        this.contents = contents;
    }

}
