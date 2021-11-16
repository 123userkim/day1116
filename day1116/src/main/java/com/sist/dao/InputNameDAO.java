package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sist.vo.InputNameVO;

public class InputNameDAO {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private String user = "c##sist";
	private String password = "sist";
	
	public ArrayList<InputNameVO>listAll(String name){
		
		ArrayList<InputNameVO>list = new ArrayList<InputNameVO>();
		String sql="select 극장이름, 상영관.상영관번호, 영화제목, 날짜, 좌석번호, 가격"
				+ "	from 상영관, 극장, 예약, 고객"
				+ "	where 상영관.극장번호 = 극장.극장번호 and"
				+ " 	상영관.극장번호 = 예약.극장번호 and"
				+ " 	예약.상영관번호 = 상영관.상영관번호 and"
				+ " 	예약.고객번호 = 고객.고객번호 and"
				+ " 	이름 =?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next()) {// 날짜, 좌석번호, 가격
				list.add(new InputNameVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getInt(5), rs.getInt(6)));
		}
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				
				if(pstmt != null) {
					pstmt.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			}catch (Exception e) {
		
			}
		}
		
		
		
		return list;
	}
}

