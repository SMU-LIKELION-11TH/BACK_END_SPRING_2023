package smu.likelion.springtutorial.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "posts")
public class Post {
    //PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long post_id;

    //User id
    @Column(name = "user_id")
    private Long user_id;
    //Post title
    @Column(name = "title")
    private String title;
    //Post contents
    @Column(name = "content")
    private String content;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private Timestamp created_at;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private Timestamp updated_at;

    @Column(name = "status")
    private int status;
}
