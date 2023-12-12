package com.vo;
//JDBC API -> myBatis(ORM 매핑오픈소스 - if문 지원함, 동적쿼리를 지원함 - SQL문 그대로 사용) -> Hibernate(ORM 프레임워크 - SQL문 없다. 그런데 조회됨)
//JPA(DB연동 마지막 목표) : 좋다 나쁘다 문제 아님. 장단점이 분명하다. 단점) 튜닝 안 됨. 복잡한 계산식은 SQL문 사용이 유리함.
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//왜 롬복을 사용하지?
//getter/setter메소드를 추가하지 않아도 괜찮다
//전변을 private으로 선언하였다 : 캡슐레이션(고유한 정보들을 외부에서 직접 수정하는 걸 막는다)

@Data //@Setter, @Getter
@NoArgsConstructor
public class BoardVO {
	private int b_no      =0;//     
	private String b_title   =null;//     
	private String b_writer  =null;//     
	private String b_content =null;//     
	private int b_hit    =0;//     
	private String b_date    =null;//     
	private String b_file    =null;//     
	//Lombok에서 제공하는 @Builder를 사용하면 파라미터 갯수나 타입을 일일이 맞추지 않고도 자유롭게 사용 가능하다
	//사용이란 생성자의 파라미터 값을 통한 전역변수들의 초기화 작업
	@Builder
	public BoardVO(int b_no, String b_title, String b_writer, String b_content, int b_hit, String b_date, String b_file) {
		super(); //디폴트 생성자 호출 : 왜냐하면 파라미터 갖는 생성자가 하나라도 있으면 디폴트 생성자를 제공하지 않음
		this.b_no = b_no;
		this.b_title = b_title;
		this.b_writer = b_writer;
		this.b_content = b_content;
		this.b_hit = b_hit;
		this.b_date = b_date;
		this.b_file = b_file;
	}
}
