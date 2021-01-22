package com.java.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dao.BoardDAO;
import com.java.dto.BoardDTO;

public class BDeleteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int bId = Integer.parseInt(request.getParameter("bId"));

		BoardDTO dto = new BoardDTO();
		dto.setbId(bId);
		
		BoardDAO.deleteBoard(dto);
	}

}
