package smu.likelion.springtutorial.service;


import smu.likelion.springtutorial.domain.Post;

import java.util.*;

public interface PostService {

    public Post save(Post post);
    public Post findById(Long id);
//    public List<Post> findAll();
}
