package com.java.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java.web.dto.UserDTO;

public class UserDAO {
	
	//회원 정보 삽입 메소드 
	public static void insUser(UserDTO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "insert into user "
				+" (userID,userPassword,userName,userGender,userEmail) "
				+" values "
				+" (?, ?, ?,? ,?)";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1,param.getUserID());
			ps.setString(2,param.getUserPassword());
			ps.setString(3,param.getUserName());
			ps.setString(4,param.getUserGender());
			ps.setString(5,param.getUserEmail());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtils.close(con, ps);
		}
		
	}
	
	
	
	
	
	//회원가입시 아이디 중복 유무
	public static int joinCheck(UserDTO param) {
		int result = -1;
		//오류 -1 
		//성공하면 1
		//아이디 있을시 0
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select * from user where userID = ? ";
		
		try {
			System.out.println(param.getUserID());
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getUserID());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				System.out.println("이미 존재하는 아이디입니다.");
				result = 0;
				return result;
			
			}else {
				System.out.println("가입 가능한 아이디입니다.");
				result = 1;
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtils.close(con, ps, rs);
		}
		
	
		return result;
	}
	
	// 로그인확인 유무 
	public static int loginCheck(UserDTO param) {
		int result = -1;
		
		// 로그인 성공시 1 
		// 비밀번호 틀렸을시 0
		// 아이디 없음 -1

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select userID, userPassword from user where userID = ? ";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getUserID());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				if(param.getUserID().equals(rs.getString("userID"))){
					if(param.getUserPassword().equals(rs.getString("userPassword"))) {
						System.out.println("로그인이 성공 하였습니다");
						result = 1;
						return result;
					}else {
						System.out.println("비밀 번호 가 틀렸습니다");
						result = 0;
						return result;
					}
					
				} 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtils.close(con, ps, rs);
		}	
		
		System.out.println("아이디 없음 ");
		return result;
	}
	
	

}
