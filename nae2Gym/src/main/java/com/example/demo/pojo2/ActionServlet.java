package com.example.demo.pojo2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import lombok.extern.slf4j.Slf4j;
//Restful API란 무엇인가?
//전송방식 : 바이너리 - UI솔루션이 지원하는 모드 중 한 가지
@SuppressWarnings("serial")
//@Slf4j : Logger를 쓰지 않고도 사용할 수 있다
@WebServlet("*.gd2")
public class ActionServlet extends HttpServlet {
	Logger logger = Logger.getLogger(ActionServlet.class);
	
	protected void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String  uri = req.getRequestURI(); // => /notice/noticeInsert.gd?n_title=a&n_content=b
		logger.info(uri);
		String context = req.getContextPath();// /
		logger.info(context);
		String command = uri.substring(context.length()+1);//-> notice/noticeInsert.gd
		logger.info(command);
		//뒤에 의미없는 확장자 gd를 잘라내기
		int end = command.lastIndexOf(".");//점이 있는 위치정보를 가져온다
		logger.info(""+end);
		command =  command.substring(0,end);//-> notice/noticeInsert까지만 가져온다. .gd는 빼고서....
		logger.info(command);//-> board/boardList or notice/noticeInsert or notice/noticeUpdate or notice/noticeDelete
		String upmu[] = null;
		String result = null; // -> redirect:/board/boardList.jsp, forward:/board/boardList.jsp
		upmu = command.split("/");
		for(String name:upmu) {
			logger.info(name);
		}
		
		Controller controller = new BoardController();
		if("board".equals(upmu[0])) {
			logger.info("workname - board - execute 호출");
			req.setAttribute("upmu",upmu);
			result = controller.execute(req, res);//여기서 BoardController의 path값이 담김
		}
		//BoardController를 경유한 다음 리턴 값으로 문자열을 받았다
		//이 문자열을 잘라서 pageMove에 담아준다
		// 1. 널 체크하기
		// 2. 문자열 배열을 선언할 것
		// 3. 콜론이 포함되어 있나?
		// 4. 콜론이 없는 경우도 처리할 것
		// 1) redirect 인 경우 : webapp - "redirect:/board/boardList.jsp"
		// 2) forward 인 경우 : webapp - "forward:/board/boardList.jsp"
		// 3)/WEB-INF/jsp/ - "/board/boardList.jsp"
		if(result != null) {
			String pageMove[] = null;
			if(result.contains(":")) {
				logger.info(": 이 포함되어 있어요");
				//-> redirect:
				pageMove = result.split(":"); //[0]=redirect or forward [1]=board/boardList
				logger.info(pageMove);
			}// end of 콜론이 있는 경우
			//콜론이 없는 경우
			else {
				pageMove = result.split("/"); //[0]=board [1]=boardList
				logger.info(pageMove);
			}// end of 콜론이 없는 경우
			logger.info(pageMove[0] + ", " + pageMove[1]);
			if(pageMove != null) {
				//치환을 한 번 더 함
				String path = pageMove[1]; // board/boardList
				if("redirect".equals(pageMove[0])) {
					res.sendRedirect("/"+path+".jsp"); // board/boardList.jsp
				}// end of sendRedirect
				else if("forward".equals(pageMove[0])) {
					RequestDispatcher view = req.getRequestDispatcher("/"+path+".jsp");
					view.forward(req, res);
				}// end of forward 
				else {//콜론이 없는 경우에 실행되는 코드 : WEB-INF
					path = pageMove[0]+"/"+pageMove[1]; //board/boardList
					// /WEB-INF/jsp/board/boardList.jsp : 스프링에서는 ViewResolver가 해 줌
					RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/jsp/"+path+".jsp");
					view.forward(req, res);
				}//end of 배포 위치가 WEB-INF/ 아래인 경우
			}////end of pageMove 배열이 null이 아닌 경우
		}//////end of if
	}////////end of doService
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doService(req, res);
	}
	//쿼리스트링, ?, 링크, header, 제한적임
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doService(req, res);
	}
	//body, 서버인터셉트 안 당함, 무조건 서버전달, 제한이 없음 - 바이너리 타입(첨부파일)
	//POST 방식 : enctype="multipart/form-data" - 바이너리 전달 - 문자+숫자 - 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doService(req, res);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doService(req, res);
	}

}
