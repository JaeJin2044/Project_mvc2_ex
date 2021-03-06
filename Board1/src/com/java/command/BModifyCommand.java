package com.java.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dao.BoardDAO;
import com.java.dto.BoardDTO;

public class BModifyCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int bId = Integer.parseInt(request.getParameter("bId"));
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		BoardDTO dto = new BoardDTO();
		dto.setbId(bId);
		dto.setbName(bName);
		dto.setbTitle(bTitle);
		dto.setbContent(bContent);
		
		BoardDAO.updateBoard(dto);
		
	}

}
