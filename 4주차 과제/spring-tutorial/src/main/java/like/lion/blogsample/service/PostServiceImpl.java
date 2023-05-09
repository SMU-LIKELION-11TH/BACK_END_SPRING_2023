package like.lion.blogsample.service;

import ch.qos.logback.core.encoder.EchoEncoder;
import like.lion.blogsample.domain.Post;
import like.lion.blogsample.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

//PostService 인터페이스를 구현 (implementation 키워드 활용)
//인터페이스에서 정의한 메서드를 OverRide 하고 구현
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Override
    //작성할 때에는 반환이 크게 필요하진 않지만 작성 내용을 확인하는 용도로 Post 클래스 타입을 반환
    //Post 클래스 타입을 매개변수로 받는 메서드 정의
    public Post save(Post post) {
        try{
            return postRepository
                    .save(new Post(post.getTitle(),post.getContent()));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Optional<Post> findById(Long id) {
        try{
            Optional<Post> postData=postRepository.findById(id);
            if(postData.isPresent()){ //id 로 찾은 데이터가 존재할 때
                return postData; //데이터를 반환한다
            }
        }catch(Exception e){ //예외처리
            e.printStackTrace();
        }
        return null;
    }
}
