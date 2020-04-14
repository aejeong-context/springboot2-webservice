package com.jeong.app.springboot.web;

import com.jeong.app.springboot.service.posts.PostService;
import com.jeong.app.springboot.web.dto.PostsResponseDto;
import com.jeong.app.springboot.web.dto.PostsSaveRequestDto;
import com.jeong.app.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

//Bean 주입 방식 Autowired , setter, 생성자 
// 생성자 권장 - > RequiredArgsConstructor에서 final이 선언된 모든 필드를 인자값으로 하는 생성자를 대신 생성
// 의존성 관계 변경될 때마다 생성자 코드 수정하는 번거로움을 해결하기 위함
@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostService postService;
    //등록
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postService.save(requestDto);
    }
    //수정
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id,@RequestBody PostsUpdateRequestDto requestDto){
        return postService.update(id,requestDto);
    }
    //조회
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id){
        return postService.findByID(id);
    }

    //삭제
    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postService.delete(id);
        return id;
    }

}
