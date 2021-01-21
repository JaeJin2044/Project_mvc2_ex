package com.java.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dao.BoardDAO;
import com.java.dto.BoardDTO;

public class BContentCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String bId_ = request.getParameter("bId");
		int bId = Integer.parseInt(bId_);
		BoardDTO dto = new BoardDTO();
		dto.setbId(bId);
		
		request.setAttribute("content_view",BoardDAO.contentView(dto));
		
		
		
		

	}

}
