package com.jeong.app.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.*;
//클래스 필드의 Getter메소드 자동 생성
@Getter
//기본 생성자 자동 추가
@NoArgsConstructor
//테이블과 링크
//클래스 이름 -> 테이블명
@Entity
public class Posts {
    //PK설정
    @Id
    //PK의 생성 규칙 IDENTITY는 auto_increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //선언하지 않아도 컬럼이 되지만 옵션변경할 때 필요
    @Column(length = 500,nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT",nullable = false)
    private String content;

    private String author;
    //해당 클래스의 빌더 패턴 클래스를 생성
    @Builder
    public Posts(String title,String content,String author){
        Assert.hasText(title,"title must not be null");
        Assert.hasText(content,"title must not be null");
        this.title=title;
        this.content=content;
        this.author=author;
    }
    public void update(String title,String content){
        this.title=title;
        this.content=content;
    }

}
