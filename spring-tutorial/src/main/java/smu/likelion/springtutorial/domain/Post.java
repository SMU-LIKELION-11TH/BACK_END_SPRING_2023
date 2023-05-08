package smu.likelion.springtutorial.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="boards")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name ="board_name")
    private String boardName;

    @Column(name="board_content")
    private String boardContent;

    public Post(String boardName, String boardContent ){
        this.boardName = boardName;
        this.boardContent = boardContent;
    }


}
