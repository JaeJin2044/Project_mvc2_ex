package com.java.web.beforeMain;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.web.dao.MembersDAO;
import com.java.web.dto.MembersDTO;

/**
 * Servlet implementation class LoginOkServlet
 */
@WebServlet("/loginOk")
public class LoginOkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		MembersDTO dto = new MembersDTO();
		dto.setUser_id(user_id);
		dto.setUser_pw(user_pw);
		
		System.out.println("=========");
		System.out.println(user_id);
		System.out.println(user_pw);
		System.out.println("=========");
		int result = MembersDAO.loginCheck(dto);
		
		if(result == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("user_id", user_id);
			session.setAttribute("user_pw", user_pw);
			
			String jsp = "/WEB-INF/view/main.jsp";
			request.getRequestDispatcher(jsp).forward(request, response);		
		}else if(result ==0) {
			System.out.println("로그인 실패 ");
			response.sendRedirect("/login");
		}else if(result == -1) {
			System.out.println("로그인 실패 ");
			response.sendRedirect("/login");
		}
		
		
		
	}

}
