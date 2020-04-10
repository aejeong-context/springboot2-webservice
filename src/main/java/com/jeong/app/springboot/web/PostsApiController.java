package com.jeong.app.springboot.web;

import com.jeong.app.springboot.service.posts.PostService;
import com.jeong.app.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//Bean 주입 방식 Autowired , setter, 생성자 
// 생성자 권장 - > RequiredArgsConstructor에서 final이 선언된 모든 필드를 인자값으로 하는 생성자를 대신 생성
// 의존성 관계 변경될 때마다 생성자 코드 수정하는 번거로움을 해결하기 위함
@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostService postService;
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postService.save(requestDto);
    }

}
