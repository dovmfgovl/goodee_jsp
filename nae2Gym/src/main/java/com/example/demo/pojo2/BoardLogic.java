package com.example.demo.pojo2;

import org.apache.log4j.Logger;

//나는 Controller라는 인터페이스를 implements 하지 않아서 어떤 제약조건(추상 메소드(execute(req, res) - Tomcat이 제공해 줌. 
//		단, 서블릿이어야 한다 - 그런데 서블릿 아니어도 스프링은 지원해줌)도 해당 안 됨
//나는 순수한 자바 클래스이다(순수성 - 원자성 : 다른 이종간의 결합에서 사용 가능한 상태라는 것이 장점).
public class BoardLogic {
	Logger logger = Logger.getLogger(BoardLogic.class);
}
