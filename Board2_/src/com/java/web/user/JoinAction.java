package com.java.web.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.web.dao.UserDAO;
import com.java.web.dto.UserDTO;

/**
 * Servlet implementation class JoinAction
 */
@WebServlet("/joinAction")
public class JoinAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		System.out.println("doPost");
		String userID = request.getParameter("userID");
		String userPassword = request.getParameter("userPassword");
		String userName = request.getParameter("userName");
		String userGender = request.getParameter("userGender");
		String userEmail = request.getParameter("userEmail");
		
		UserDTO dto = new UserDTO();
		
		dto.setUserID(userID);
		dto.setUserPassword(userPassword);
		dto.setUserName(userName);
		dto.setUserEmail(userEmail);
		dto.setUserGender(userGender);
		
		int result = UserDAO.joinCheck(dto);
		System.out.println(result);
		// 1성공 0존재하는 아이디 
		PrintWriter script = response.getWriter();
		if(result == 1 ) {
			UserDAO.insUser(dto);
			script.println("<script> alert('회원가입 성공 축하'); location.href='/login'; </script> ");

		}else {
			script.println("<script>");
			script.println("alert('이미 존재하는 아이디입니다 다른 아이디로 회원가입부탁드려용!!');");
			script.println("history.back()");
			script.println("</script>");
		}
		
		
		
		
		
	}

}
