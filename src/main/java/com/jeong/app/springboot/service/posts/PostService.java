package com.jeong.app.springboot.service.posts;

import com.jeong.app.springboot.domain.posts.PostRepository;
import com.jeong.app.springboot.domain.posts.Posts;
import com.jeong.app.springboot.web.dto.PostsResponseDto;
import com.jeong.app.springboot.web.dto.PostsSaveRequestDto;
import com.jeong.app.springboot.web.dto.PostsUpdateRequestDto;
import javafx.geometry.Pos;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postsRepository;
    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }
    //더티체킹 - 트랜잭션이 끝나는 시점에 변화가 있는 모든 엔티티 객체를 DB에 자동으로 반영
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        posts.update(requestDto.getTitle(),requestDto.getContent());
        return id;
    }
    @Transactional
    public PostsResponseDto findByID(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다.id="+id));
        return new PostsResponseDto(entity);
    }
}
