package com.java.web.dao;

import java.sql.*;
import java.sql.PreparedStatement;

import com.java.web.DbUtils;
import com.java.web.dto.MembersDTO;

public class MembersDAO {
	
	
	
	
	public static int loginCheck(MembersDTO param) {
		
		int result = 0 ;
		//로그인 성공시 => 1 
		//로그인 실패시 (비밀번호 잘못입력)=> 0
		//로그인 실패(잘못된 아이디) => -1
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select * from members where user_id = ?";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getUser_id());
			rs = ps.executeQuery();
			
			System.out.println("조건문 시작전");
			System.out.println(sql);
			
			
			
			if(rs.next()) {
				
				System.out.println("==============================================");
				System.out.println("db에서 넘어온값");
				System.out.println(rs.getString("user_id"));
				System.out.println(rs.getString("user_pw"));
				System.out.println("================================================");
				System.out.println("파라미터 값 ");
				System.out.println(param.getUser_id());
				System.out.println(param.getUser_pw());
				System.out.println("================================================");
				
				if(param.getUser_id().equals(rs.getString("user_id"))) {
					
					if(param.getUser_pw().equals(rs.getString("user_pw"))) {
						System.out.println("로그인성공");
						result = 1;
					}else {
						System.out.println("비밀번호 잘못 입력");
						result = -1;
					}
					
				}else {
					System.out.println("아이디 잘못 입력");
					result = 0;
				}
			
				
			}
			
			
		
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			DbUtils.close(con, ps, rs);
		}
		return result;
		
	}
	
	
	
	
	
	
	
	//조인.jsp페이지에서 입력한값 db에 넣는 메소드 !!! 회원가입이라 생각하면됨 ..
	//중복된 아이디,이메일,연락처 있을때는 안된다라는 내용 구현해야함 
	//Members테이블 설계시 유니크키?  설정 여부 
	public static void insertMembers(MembersDTO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "insert into members "
				+" (user_id, user_name, user_nick, user_pw, user_phone, user_age, user_gender, user_mail, user_addr1, user_addr2)"
				+" values "
				+" (?, ?, ?, ?, ?,?,?, ?, ?, ?)";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getUser_id());
			ps.setString(2, param.getUser_name());
			ps.setString(3, param.getUser_nick());
			ps.setString(4, param.getUser_pw());
			ps.setString(5, param.getUser_phone());
			ps.setString(6, param.getUser_age());
			ps.setString(7, param.getUser_gender());
			ps.setString(8, param.getUser_mail());
			ps.setString(9, param.getUser_addr1());
			ps.setString(10, param.getUser_addr2());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtils.close(con, ps);
		}
		
	}

}
