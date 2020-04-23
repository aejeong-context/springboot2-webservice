package com.jeong.app.springboot.web;

import com.jeong.app.springboot.config.auth.dto.SessionUser;
import com.jeong.app.springboot.service.posts.PostService;
import com.jeong.app.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

//머스테치 스타터가 ViewResolver를 자동으로 지정해줌
@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostService postsService;
    private  final HttpSession httpSession;
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts",postsService.findAllDesc());
        //CustomOAuth2UserService에서 로그인 성공 시 세션에 SessionUser를 저장-> 로그인 성공 시 httpSession.getAttribute("user")에서 값을 가져올 수 있음
        SessionUser user= (SessionUser) httpSession.getAttribute("user");
        if(user!=null){
            model.addAttribute("userName",user.getName());
        }
        return "index";
    }
    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id,Model model){
        PostsResponseDto dto = postsService.findByID(id);
        model.addAttribute("posts",dto);
        return "posts-update";
    }

}
