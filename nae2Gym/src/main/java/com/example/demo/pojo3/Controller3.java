package com.example.demo.pojo3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//1-1과 1-2와는 다르게 컨트롤 클래스부터 메소드를 쪼갠다
//메소드마다 req와 res를 주입 받을 수 있어야 한다.
public interface Controller3 {
	public Object execute(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException ;
	
	//게시판 구현 메소드 추가
	public Object jsonBoardList(HttpServletRequest req, HttpServletResponse res);
	public Object boardList(HttpServletRequest req, HttpServletResponse res);
	public Object boardDetail(HttpServletRequest req, HttpServletResponse res);
	public Object boardInsert(HttpServletRequest req, HttpServletResponse res);
	public Object boardUpdate(HttpServletRequest req, HttpServletResponse res);
	public Object boardDelete(HttpServletRequest req, HttpServletResponse res);
	public Object imageDownload(HttpServletRequest req, HttpServletResponse res);
	public Object imageUpload(HttpServletRequest req, HttpServletResponse res);
	public Object imageGet(HttpServletRequest req, HttpServletResponse res);
}
//ActionForward -> String -> Object