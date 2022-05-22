package com.jojoldu.book.springboot.domain.posts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/*
@AfterEach
    JUnit에서 단위 테스트가 끝날 때마다 수행되는 메소드를 지정한다.
    보통은 배포 전 전체 테스트를 수행할 때 테스트간 데이터 침범을 막기위해 사용한다.
    여러 테스트가 동시에 수행되면 테스트용 데이터베이스인 h2에
    데이터가 그대로 남아 있어 다음 테스트 실행 시 테스트가 실패할 수 있다.
postsRepository.save
    테이블 posts에 insert/update 쿼리를 실행한다.
    id 값이 있다면 update 쿼리가, 없다면 insert 쿼리가 실행된다.
postsRepository.findAll
    테이블 posts에 있는 모든 데이터를 조회해오는 메소드이다.
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("jojolju@gmail.com")
                .build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
