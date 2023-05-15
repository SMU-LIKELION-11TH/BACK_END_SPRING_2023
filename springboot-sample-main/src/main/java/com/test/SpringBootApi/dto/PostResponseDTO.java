package com.test.SpringBootApi.dto;

import com.test.SpringBootApi.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PostResponseDTO {
    private long id;
    private String title;
    private String content;
}
