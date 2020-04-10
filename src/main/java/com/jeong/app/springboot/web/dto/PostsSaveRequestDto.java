package com.jeong.app.springboot.web.dto;

import com.jeong.app.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.swing.text.html.parser.Entity;

//Entity클래와 Controller에서 쓸 Dto는 분리해서 사용하는게 중요
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;
    @Builder
    public PostsSaveRequestDto(String title,String content,String author){
        this.title=title;
        this.content=content;
        this.author=author;
    }
    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}

