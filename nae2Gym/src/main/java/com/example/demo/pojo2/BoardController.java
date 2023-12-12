package com.example.demo.pojo2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.example.demo.pojo1.ActionForward;

import com.example.demo.pojo1.NoticeController;
import com.example.demo.pojo1.NoticeLogic;
/*
 * upmu[] : 내려갈 때 -> ActionServlet -> BoardController로 연결될 때
 * -> 개선점(1-3버전) -> spring -> XXXHandlerMapping -> BoardController 클래스에서부터 메소드를 쪼갤 수는 없나?(현재는 if문으로 되어 있어 가독성, 재사용성 떨어짐)
 * pageMove[] : 올라올 때
 */
//@Controller : 스프링에서는 클래스 사이의 결합도를 낮추기 위해 상속(결합도가 높아지니까)을 포기하였다
//@RequestMapping(/notice/*) : 2번째 URL 매핑 방법
public class BoardController implements Controller {
	Logger logger = Logger.getLogger(BoardController.class);
	BoardLogic nLogic = new BoardLogic();//이른
	//@GetMapping("noticeList.gd") : 객체 주입 받으려면 ApplicationContext로부터 빈 관리를 받을 때만 사용 가능함 - req, res 주입해주기 때문에
	//public String noticeList(HttpServletRequest req, HttpServletResponse res) {}
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String upmu[] = (String[])req.getAttribute("upmu");
		String path = null;
		/*
		//전체조회일 때 : select / n건 - List<Map | VO> - list.jsp
		//상세보기와 응답페이지 이름이 달라서 메소드를 분리한다
		// 1) 배포위치가 WEB-INF 일 때 : /WEB-INF/jsp/(workname)/메소드이름 or upmu[1].jsp
		// 2) 배포위치가 webapp 일 때
		if(true) {
			return path = "1";
		}
		
		//상세조회일 때 : select / 1건 - Map or VO - read.jsp
		else if("boardDetail".equals("boardDetail")) {
			path = "redirect:2";//redirect
		}
		//공통분모 : 반환값이 int이다.commit과 rollback 대상이다
		//입력 | 수정 | 삭제인 경우 모두 1이라면 어느 페이지로 이동할까? - 목록(select: /board/boardList.gd2 - 이 뒤에서 forward 처리해야 함)을 보여주세요
		//등록일 때 : post 방식 - insert : 1(수정성공) or 0(수정 안 됨)
		else if("boardInsert".equals("boardInsert")) {
			path = "redirect:3";
		}
		
		//수정일 때 : get, put 방식(모든 방식을 doService로 묶었기 때문에 큰 의미는 없다) - Restful 상징성을 표현함 - update : 1(수정성공) or 0(수정 안 됨)
		else if(true) {
			path = "redirect:4";
		}
		
		//삭제일 때 : delete 방식 - 스프링 수업 땐 분리해서 할 것임 - delete : 1(수정성공) or 0(수정 안 됨)
		else if(true) {
			path = "redirect:/board/boardDetail";
		}
		*/
		return path;
		//return "redirect:/notice/noticeList.jsp"; //webapp
		//return "forward:/notice/noticeList.jsp"; //webapp - 요청이 유지되는 것으로 판단해서 서블릿이 쥐고 있는 값을 jsp에서도 사용할 수 있다.
		//return "/notice/noticeList"; //WEB-INF/jsp/notice 아래
	}

}
