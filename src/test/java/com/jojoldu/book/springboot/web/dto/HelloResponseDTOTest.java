package com.jojoldu.book.springboot.web.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/*
assertThat
    assertj 라는 테스트 검증 라이브러리의 메소드이다.
    검증하고 싶은 대상을 메소드 인자로 받는다.
    메소드 체이닝이 지원되어 isEqualTo()와 같은 메소드를 이어 사용할 수 있다.
    isEqualTo()
        assertj 의 동등 비교 메소드이다.
        assertThat 에 있는 값과 isEqualTo의 값을 비교해서 같을 때만 성공이다.
 */
public class HelloResponseDTOTest {
    @Test
    public void 롬복_기능_테스트() {
        String name = "test";
        int amount = 1000;

        HelloResponseDTO dto = new HelloResponseDTO(name, amount);

        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
