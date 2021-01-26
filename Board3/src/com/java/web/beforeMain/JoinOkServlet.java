package com.java.web.beforeMain;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.web.dao.MembersDAO;
import com.java.web.dto.MembersDTO;

/**
 * Servlet implementation class JoinOkServlet
 */
@WebServlet("/joinOk")
public class JoinOkServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_name = request.getParameter("user_name");
		String user_nick = request.getParameter("user_nick");
		String user_phone = request.getParameter("user_phone");
		String user_age = request.getParameter("user_age");
		String user_gender = request.getParameter("user_gender");
		String user_mail = request.getParameter("user_mail");
		String user_addr1 = request.getParameter("user_addr1");
		String user_addr2 = request.getParameter("user_addr2");
		
		
		MembersDTO dto = new MembersDTO();
		dto.setUser_id(user_id);
		dto.setUser_pw(user_pw);
		dto.setUser_name(user_name);
		dto.setUser_nick(user_nick);
		dto.setUser_phone(user_phone);
		dto.setUser_age(user_age);
		dto.setUser_gender(user_gender);
		dto.setUser_mail(user_mail);
		dto.setUser_addr1(user_addr1);
		dto.setUser_addr2(user_addr2);
		
		MembersDAO.insertMembers(dto);
		
		response.sendRedirect("/login");
		
		
	}

}
