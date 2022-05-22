package com.jojoldu.book.springboot.web;

import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/*
@ExtendWith(SpringExtension.class)
    테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행한다.
    여기서는 SpringRunner라는 스프링 실행자를 사용하며
    스프링 부트 테스트와 JUnit 사이에 연결자 역할을 한다.
    JUnit5부터 이미 스프링 부트가 제공하는 모든 테스트용 어노테이션에
    메타 어노테이션으로 적용되어 생략가능하다.
@WebMvcTest
    Web(Spring MVC)에 집중할 수 있는 어노테이션이다.
    선언 시 @Controller, @ControllerAdvice 등이 사용 가능하며
    @Service, @Repository 등은 사용 불가능하다.
    여기서는 컨트롤러만 사용하기 때문에 선언한다.
@Autowired
    스프링이 관리하는 빈을 주입 받는다.
private MockMvc mvc
    웹 API 를 테스트할 때 사용하며
    스프링 MVC 테스트의 시작점이자 HTTP GET, POST 등에 대한 API 테스트 가능하다.
mvc.perform(get("/hello"))
    MockMvc 를 통해 /hello 주소로 HTTP GET 요청한다.
    체이닝이 지원되어 아래와 같이 여러 검증 기능을 이어서 선언할 수 있다.
    .andExpect(status().isOK())
        mvc.perform의 결과를 검증하는데
        HTTP header의 status(200, 404, 500 등의 상태)를 검증한다.
        여기서 200인지 아닌지를 검증한다.
    .andExpect(content().string(hello))
        mvc.perform 의 결과를 검증하는데
        응답 본문의 내용을 검증한다.
        Controller 에서 'hello' 를 리턴하기 때문에 이 값이 맞는지를 검증한다.
    .param
        API 테스트를 할 때 사용될 요청 파라미터를 설정한다.
        단, 값은 String만 허용한다.
        숫자/날짜 등의 데이터도 등록할 떄는 문자열로 변경해야만 가능하다.
    jsonPath
        JSON 응답값을 필드별로 검증할 수 있는 메소드이다.
        $를 기준으로 필드명을 명시한다.
 */
// @ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void returnApple() throws Exception {
        String apple = "apple";

        mvc.perform(get("/apple"))
                .andExpect(status().isOk())
                .andExpect(content().string(apple));
    }

    @Test
    public void helloDTO가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                .param("name", name)
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
