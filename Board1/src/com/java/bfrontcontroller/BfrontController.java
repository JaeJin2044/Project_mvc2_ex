package com.java.bfrontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.BCommand;
import com.java.command.BContentCommand;
import com.java.command.BListCommand;
import com.java.command.BWriteCommand;

@WebServlet("*.do")
public class BfrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet실행");
		actionDo(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost실행");
		actionDo(request,response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo");
		request.setCharacterEncoding("UTF-8");
		
		String viewPage = null;
		BCommand command = null;
		
		String uri = request.getRequestURI();
		
		if(uri.equals("/list.do")) {
			command = new BListCommand();
			command.execute(request, response);
			viewPage = "/WEB-INF/jsp/list.jsp";
			
		}else if(uri.equals("/write_view.do")) {
			viewPage = "/WEB-INF/jsp/write_view.jsp";
			
		}else if(uri.equals("/write.do")) {
			command = new BWriteCommand();
			command.execute(request, response);
			viewPage = "/list.do";
		}else if(uri.equals("/content_view.do")) {
			command = new BContentCommand();
			command.execute(request, response);
			viewPage ="/WEB-INF/jsp/content_view.jsp";
		}
		
		
		
		
		
		
		//이부분 sendRedirect부분 안넣어주니까 write하고 나서 주소 값이 write.do라.. 새로고침 누르면 아까 입력했던 값이 또 추가됨... ㅠㅠ
		//여기 if문 빼고 dispatcher만 하면 글 쓰고 나서 새로고침 누르면 uri가 같아서 계속해서 글이 생성됨...
		//그 문제를 해결하고자 .. sendRedirect로 uri 바꿔서 리스트로 돌려 보냄 
		if(viewPage.equals("/list.do")) {
			response.sendRedirect(viewPage);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
		
		
		

	
	}

}
