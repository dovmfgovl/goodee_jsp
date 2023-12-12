package com.example.demo.pojo2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import lombok.extern.slf4j.Slf4j;
//Restful API란 무엇인가?
//전송방식 : 바이너리 - UI솔루션이 지원하는 모드 중 한 가지
@SuppressWarnings("serial")
//@Slf4j : Logger를 쓰지 않고도 사용할 수 있다
public class ActionServlet extends HttpServlet {
	Logger logger = Logger.getLogger(ActionServlet.class);
	
	protected void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Controller controller = new BoardController();
	}
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
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}

}
