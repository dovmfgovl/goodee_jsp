package com.example.demo.pojo2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
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
 * 
 * XXXLogic 메소드를 호출할 때 BoardLogic클래스의 인스턴스화가 선행됨(DI지원)
 * 여기는 POJO이므로 제어권을 개발자인 내가 가지니까 이른 인스턴스화 부분은 생략함
 * 객체에 대한 라이프사이클 관리 책임이 개발자인 내게 있다
 * 
 * 아쉬운 점
 * BoardController에서 메소드로 분할이 안 되었다는 점
 * 대신 if문으로 처리하였다 - 별로다
 * Reflection API 깊은 고민 : ApplicationContext, BeanFactory 스프링 컨테이너
 * IoC 직접 구현해 보는 경험 : 시니어
 */
//@Controller : 스프링에서는 클래스 사이의 결합도를 낮추기 위해 상속(결합도가 높아지니까)을 포기하였다
//@RequestMapping(/notice/*) : 2번째 URL 매핑 방법
import com.google.gson.Gson;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.util.HashMapBinder;
public class BoardController implements Controller {
	Logger logger = Logger.getLogger(BoardController.class);
	BoardLogic bLogic = new BoardLogic();//이른
	//@GetMapping("noticeList.gd") : 객체 주입 받으려면 ApplicationContext로부터 빈 관리를 받을 때만 사용 가능함 - req, res 주입해주기 때문에
	//public String noticeList(HttpServletRequest req, HttpServletResponse res) {}
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String upmu[] = (String[])req.getAttribute("upmu");
		String path = null;
		Map<String, Object> pMap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		//전체조회일 때 : select / n건 - List<Map | VO> - list.jsp
		//상세보기와 응답페이지 이름이 달라서 메소드를 분리한다
		// 1) 배포위치가 WEB-INF 일 때 : /WEB-INF/jsp/(workname)/메소드이름 or upmu[1].jsp
		// 2) 배포위치가 webapp 일 때	
		if("boardList".equals(upmu[1])) {//select : 1-3버전에서는 이 장면을 메소드 단위로 변경하고 싶다. (req, res) 넘겨 받을 수 있어야 한다 <- 이 문제를 해결해야함
			logger.info("boardList");
			List<Map<String ,Object>> bList = null;//nList.size()가 n개 
			// NoticeLogic의 메소드 호출 - 객체주입 - 내가(책임) 아님 스프링(제어역전)
			hmb.bind(pMap);  
			bList = bLogic.boardList(pMap);
			logger.info(bList);
			//원본에다가 담아 두자
			req.setAttribute("bList", bList);
			//pageMove[0]=forward, pageMove[1]=/board/boardLIst
			path = "forward:board/boardList"; // url은 안 바뀐다. 화면은 바뀐다. 파일은 .jsp이다. 
			//path = "redirect:board/boardList"; // webapp/board/boardList로 이동하고자 할 때 //url 바뀐다(gd2->jsp로). 화면도 바뀐다.
			//path = "board/boardList"; // /WEB-INF/board/boardList로 이동하고자 할 때
		}//end of 목록조회		
		//상세조회일 때 : select / 1건 - Map or VO - read.jsp
		else if("boardDetail".equals(upmu[1])) {
				logger.info("boardDetail");
				List<Map<String ,Object>> bList = null;//nList.size()=1
				// NoticeLogic의 메소드 호출 - 객체주입 - 내가(책임) 아님 스프링(제어역전)
				//select * from notice where n_no=5;
				hmb.bind(pMap);
				bList = bLogic.boardList(pMap);
				//원본에다가 담아 두자
				req.setAttribute("bList", bList);
				path = "forward:/board/boardDetail.jsp";
		}
		//공통분모 : 반환값이 int이다. commit과 rollback 대상이다
		//입력 | 수정 | 삭제인 경우 모두 1이라면 어느 페이지로 이동할까? - 목록(select: /board/boardList.gd2 - 이 뒤에서 forward 처리해야 함)을 보여주세요
		//등록일 때 : post 방식 - insert : 1(수정성공) or 0(수정 안 됨)
		else if("boardInsert".equals(upmu[1])) {//insert
			logger.info("boardInsert");
			int result = 0;
			hmb.bind(pMap);
			result = bLogic.boardInsert(pMap);
			if(result == 1) { //글 등록 성공했을 때
				path = "redirect:/board/boardList.gd2"; //jsp --(redirect)--> boardInsert.gd2 --(redirect)--> boardList.gd2 --(forward)--> jsp
			}else {
				path = "redirect:/board/boardError.jsp";
			}
		}/////////////////end of boardInsert
		
		//수정일 때 : get, put 방식(모든 방식을 doService로 묶었기 때문에 큰 의미는 없다) - Restful 상징성을 표현함 - update : 1(수정성공) or 0(수정 안 됨)
		else if("boardUpdate".equals(upmu[1])) {//update
			logger.info("boardUpdate");
			int result = 0;
			hmb.bind(pMap);
			result = bLogic.boardUpdate(pMap);
			if(result == 1) { //글 등록 성공했을 때
				path = "redirect:/board/boardList.gd2";
			}else {
				path = "redirect:/board/boardError.jsp";
			}
		}/////////////////end of boardUpdate
		
		//삭제일 때 : delete 방식 - 스프링 수업 땐 분리해서 할 것임 - delete : 1(수정성공) or 0(수정 안 됨)
		else if("boardDelete".equals(upmu[1])) {//delete
			logger.info("boardDelete");
			int result = 0;
			hmb.bind(pMap);
			result = bLogic.boardDelete(pMap);
			if(result == 1) { //글 등록 성공했을 때
				path = "redirect:/board/boardList.gd2";
			}else {
				path = "redirect:/board/boardError.jsp";
			}
		}//////////////////end of boardDelete - 조건문 블록 하나하나가 메소드로 분할 될 것
		
		return path;
		//return "redirect:/notice/noticeList.jsp"; //webapp
		//return "forward:/notice/noticeList.jsp"; //webapp - 요청이 유지되는 것으로 판단해서 서블릿이 쥐고 있는 값을 jsp에서도 사용할 수 있다.
		//return "/notice/noticeList"; //WEB-INF/jsp/notice 아래
	}//////////////end of execute
}/////////////////end of BoardController