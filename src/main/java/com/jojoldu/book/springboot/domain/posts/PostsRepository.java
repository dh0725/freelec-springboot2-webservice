package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/*
ibatis, MyBatis등에서 DAO라고 불리는 DB Layer 접근자이다.
JPA에서는 Repository라고 부르며 인터페이스로 생성한다.
JpaRepository<Entity 클래스, PK 타입>으로 상속하면
기본적인 CRUD 메소드가 자동으로 생성된다.
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
