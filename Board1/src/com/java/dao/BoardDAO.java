package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.java.dto.BoardDTO;
import com.java.jaejin.dbutils.DbUtils;



public class BoardDAO {
	//글 수정하는 메소드 
	public static void updateBoard(BoardDTO param) {
		
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "update mvc_board set bName = ?, bTitle = ?, bContent = ? "
				+" where bId = ?";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getbName());
			ps.setString(2, param.getbTitle());
			ps.setString(3, param.getbContent());
			ps.setInt(4, param.getbId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtils.close(con, ps);
		}
	}
	
	// 글 삭제 하는 메소드 
	public static void deleteBoard(BoardDTO param) {
		Connection con = null;
		PreparedStatement  ps = null;
		
		String sql = "delete from mvc_board where bId= ?";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getbId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtils.close(con, ps);
		}
		
	}
	
	
	
	

	//리스트에 모든 자료 뿌려주는 메소드 
	public static List<BoardDTO> selBoardList(){
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<BoardDTO> vo = new ArrayList();
		
		String sql = "SELECT * FROM mvc_board";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int bId = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bGroup");
				int bStep = rs.getInt("bStep");
				int bIndent = rs.getInt("bIndent");
				
				BoardDTO dto = new BoardDTO(bId,bName,bTitle,bContent,bDate, bHit, bGroup, bStep, bIndent);
				vo.add(dto);	
			}
			return vo;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtils.close(con, ps, rs);
		}
		return null;
	}
	
	//글 쓰는 메소드 
	public static void insertBoard(BoardDTO dto) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO mvc_board (bName,bTitle,bContent) VALUES(?,?,?)";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getbName());
			ps.setString(2, dto.getbTitle());
			ps.setString(3, dto.getbContent());
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtils.close(con, ps);
		}	
	}
	
	//내용 보여주는 메소드 
	public static BoardDTO contentView(BoardDTO dto) {
		
		upHit(dto.getbId());
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		BoardDTO param = new BoardDTO();
		
		
		String sql = "select * from mvc_board where bId = ?";
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, dto.getbId());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				int bId = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bGroup");
				int bStep = rs.getInt("bStep");
				int bIndent = rs.getInt("bIndent");
				
				param = new BoardDTO(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				
			}
			return param;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtils.close(con, ps, rs);
		}
		
		return null;
	}
	
	
	//조회수 올려주는 메소드 
	private static void upHit(int bId) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "update mvc_board set bHit = bHit+1 where bId = ?"; 
				
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, bId);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtils.close(con, ps);
		}
	}
	
	
	
	
}






















