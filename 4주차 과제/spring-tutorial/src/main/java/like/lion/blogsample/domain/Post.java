package like.lion.blogsample.domain;
import javax.persistence.*;

//엔티티 클래스에 필요한 어노테이션 추가
@Entity
@Table(name="Posts")
//pk 필드와 게시글에 필요한 속성 변수 정의
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="title")
    private String title;
    @Column(name="content")
    private String content;
    public Post(){} //일반 생성자
    public Post(String title, String content){ //id 빼고 생성자에서 받음
        this.title=title;
        this.content=content;
    }
    //getter setter 정의
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
