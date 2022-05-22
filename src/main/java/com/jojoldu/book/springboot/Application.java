package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
@SpringBootApplication
    스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정
    해당 어노테이션이 위치한 부분부터 설정을 읽어나가기 떄문에 항상 프로젝트 최상단에 위치함
SpringApplication.run
    내장 WAS 실행
    굳이 톰캣 설치 없이 스프링 부트로 만들어진 JAR 파일로 실행 가능
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
