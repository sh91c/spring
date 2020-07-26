package com.pknu.user.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// DataSource import
import javax.sql.DataSource;

import org.springframework.stereotype.Component;

import com.pknu.user.dao.UserDAO;
import com.pknu.user.vo.UserVO;

@Component
public class UserDAOImpl implements UserDAO{
	// field
	private DataSource dataSource;
	
	// setter
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void addUser(UserVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			String sql = "INSERT INTO SIMPLE_MEM VALUES(?, ?) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTel());
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			
			System.out.println(vo.getName() + " 이(가) 저장되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<UserVO> getList() {
		List<UserVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = " SELECT * FROM SIMPLE_MEM\n" + 
						 " ORDER BY NAME ASC ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while( rs.next() ) {
				UserVO vo = new UserVO();
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
				
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}

	@Override
	public UserVO getView(String tel) {
		UserVO vo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = " SELECT NAME, TEL FROM SIMPLE_MEM WHERE TEL = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tel);
			rs = pstmt.executeQuery();
			
			if( rs.next() ) {
				vo = new UserVO();
				vo.setName(rs.getString("NAME"));
				vo.setTel(rs.getString("TEL"));
			}
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vo;
	}

	@Override
	public UserVO delUser(UserVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "DELETE FROM SIMPLE_MEM\n " + 
						 " WHERE TEL = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTel());
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
			System.out.println(vo.getName() + " 이(가) 삭제되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vo;
	}

	@Override
	public void updateUser(UserVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = " UPDATE SIMPLE_MEM "
					   + " SET NAME = ? "
					   + " WHERE TEL = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName()); // varchar2
			pstmt.setString(2, vo.getTel());
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
			System.out.println(vo.getName() + " 이(가) 으로되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
