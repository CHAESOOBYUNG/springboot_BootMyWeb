package com.coding404.myweb.command;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Practice1VO {
	/*
	 * 1. 스프링부트 JPA라이브러리를 사용하면 기본타입은 null을 가질 수 없기 때문에 값에 맵핑이 안됩니다.	   
	 * 그래서 wrapper형으로 반드시 선언합니다.
	 * 
	 * 2. 유효성 검사에 필요한 멤버변수에 어노테이션 설정
	 * 규제 @NotBlank > @NotEmpty > @NotNull
	 * 
	 * - @NotNull : null을 허용하지 않는다 (String, Long 등에 적용가능)
	 * - @NotBlank : null, "", " " 허용하지 않는다. (String에 적용)
	 * - @NotEmpty : null, "" 허용하지 않는다. (String, Array 등에 적용가능)
	 * - @Pattern : 정규표현 형식에 문자열로 정의할 수 있다( String에 적용가능 )
	 * - @Email : 이메일 형식만 이용
	 */
	
	private int topic_name; //PK
	private LocalDateTime topic_regdate; //DB가 default값으로 삽입
	private String topic_date; //등록일
	private String topic_id; //아이디
	private String topic_title; //제목
	private String topic_content; //내용
}
