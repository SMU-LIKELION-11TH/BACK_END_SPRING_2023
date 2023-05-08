package like.lion.blogsample.service;

import like.lion.blogsample.domain.Post;
import java.util.Optional;

//PostService 에서 필요한 메서드를 정의 (CRUD = 작성, 조회 (단건 조회 / 목록 조회) , 수정, 삭제)
//이번 과제에서는 작성과 조회만 구현
public interface PostService {

    /*Post 클래스를 인자로 받아서 사용자가 작성하려고 하는 게시글의 내용을 DB에 저장*/
    public Post save(Post post);
    //작성할 때에는 반환이 크게 필요하진 않지만 작성 내용을 확인하는 용도로 Post 클래스 타입을 반환
    //Post 클래스 타입을 매개변수로 받는 메서드 정의

    /* 조회 */
    public Optional<Post> findById(Long id); //id 통한 조회

    //단건 조회를 구현. pk를 통해 DB의 Post 레코드를 하나 Read함
    //조회한 Post 내용을 반환해야 하기 때문에 Post 타입을 반환
    //pk로 Post 를 하나 지정하기 위해 매개변수를 pk의 타입으로 받는 메서드 정의

}
