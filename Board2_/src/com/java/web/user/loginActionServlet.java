package com.java.web.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.web.dao.UserDAO;
import com.java.web.dto.UserDTO;

/**
 * Servlet implementation class loginAction
 */
@WebServlet("/loginAction")
public class loginActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");

		int result = 0 ;
		String userID = request.getParameter("userID");
		String userPassword = request.getParameter("userPassword");
		
		
		UserDTO dto = new UserDTO();
		dto.setUserID(userID);
		dto.setUserPassword(userPassword);
		
		result = UserDAO.loginCheck(dto);
		System.out.println(result);
		
		PrintWriter script = response.getWriter();
		
		if(result == 1 ) {
			HttpSession session = request.getSession();
			session.setAttribute("userID", userID);
			
			
			script.println("<script> alert('로그인 성공'); location.href='/main'; </script> ");
		
		
		
		
		}else if(result == 0) {
			script.println("<script>");
			script.println("alert('비밀번호가 틀립니다')");
			script.println("history.back()");
			script.println("</script>");
		}else if(result == -1) {
			script.println("<script>");
			script.println("alert('존재하지 않는 아이디입니다.')");
			script.println("history.back()");
			script.println("</script>");
		}
		
		
	}

}
