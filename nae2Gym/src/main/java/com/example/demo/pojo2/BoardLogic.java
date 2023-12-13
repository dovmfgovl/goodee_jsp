package com.example.demo.pojo2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

//나는 Controller라는 인터페이스를 implements 하지 않아서 어떤 제약조건(추상 메소드(execute(req, res) - Tomcat이 제공해 줌. 
//		단, 서블릿이어야 한다 - 그런데 서블릿 아니어도 스프링은 지원해줌)도 해당 안 됨
//나는 순수한 자바 클래스이다(순수성 - 원자성 : 다른 이종간의 결합에서 사용 가능한 상태라는 것이 장점).
public class BoardLogic {
	Logger logger = Logger.getLogger(BoardLogic.class);
	BoardDao bDao = new BoardDao();
	public List<Map<String, Object>> boardList(Map<String, Object> pMap) {
		logger.info("boardList");
		//웹개발에서는 NullPointerException이 발동하면 화면 자체가 안 열림
			//어떤 힌트를 보고 문제를 예측(추측)해서 하나씩 가능성을 제거해 나가는 과정을 통해 트러블슈팅을 완성함
			//ArrayList로 화면은 출력된다
		List<Map<String, Object>> bList = new ArrayList<>();//NullPointerException 방어코드로 ArrayList를 둔다
		bList = bDao.boardList(pMap);
		logger.info(bList);
		return bList; //화면과 로직을 분리하자 -> POJO F/W를 설계해 본다
	}
	//아래 메소드는 트랜잭션 처리 대상이다
	//업무적인 depth가 깊을수록 이런 상황이 발생된다
	//AOP : 수평적인 관점으로 관계설정, 개입, 처리 가능하게 지원
		//프레임워크의 한 종류로 공통된 관심사에 대해서 클래스의 어떤 지점을 접근하여 추가코드 없이 자동으로 일 처리를 가능하게 해주는 프로그래밍 기법
	// <-> OOP : 상하관계
	public int boardInsert(Map<String, Object> pMap) {
		logger.info("boardInsert");
		int result = 0;
		result = bDao.boardInsert(pMap);
		return result;
	}
	public int boardUpdate(Map<String, Object> pMap) {
		logger.info("boardUpdate");
		int result = 0;
		result = bDao.boardUpdate(pMap);
		return result;
	}
	public int boardDelete(Map<String, Object> pMap) {
		logger.info("boardDelete");
		int result = 0;
		result = bDao.boardDelete(pMap);
		return result;
	}
} 
