package com.jeong.app.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
//Dao와 같은 DB Layer접근자. JAP에서는 Repository라고 부르며 인터페이스로 생성한다.
//JapRepository<Entity클래스,PK타입> 을 상속하면 기본적인 CRUD메소드가 자동으로 생성된다.
public interface PostRepository extends JpaRepository<Posts,Long> {
}
