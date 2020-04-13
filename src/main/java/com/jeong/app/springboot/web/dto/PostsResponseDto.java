package com.jeong.app.springboot.web.dto;

import com.jeong.app.springboot.domain.posts.Posts;
import lombok.Getter;
@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    //Entity의 필드 중 일부만 사용 하므로 Entity를 받아 처리한다.
    public PostsResponseDto(Posts entity){
        this.id=entity.getId();
        this.title=entity.getTitle();
        this.content=entity.getContent();
        this.author=entity.getAuthor();

    }
}


