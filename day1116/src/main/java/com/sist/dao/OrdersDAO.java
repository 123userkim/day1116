package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sist.vo.OrdersVO;

public class OrdersDAO {
	
	//새로운 주문번호를 반환하는 메소드 정의
	public int getNextOrderId() {
		int orderid= -1;
		String sql = "select max(orderid)+1 from orders";
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, psw);
			pstmt = conn.prepareStatement(sql);			
			rs= pstmt.executeQuery();
			//한 개밖에 없다면 if
			if(rs.next()) {
				orderid = rs.getInt(1);
			}
		}catch(Exception e) {
			System.out.println("예외발생 : "+e.getMessage());
		}finally {
			
			try {
				if(conn != null) {
					conn.close();
				}if(pstmt != null) {
					pstmt.close();
				}if(rs != null) {
					rs.close();
				}				
			}catch(Exception e) {				
			}
		}		
		return orderid;		
	}
					 
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user ="c##madang";
	String psw ="madang";
	
	public int insertOrders(OrdersVO o) {
		String sql ="insert into orders values(?,?,?,?,sysdate)";
		Connection conn= null;
		PreparedStatement pstmt = null;
		
		int re= -1;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,psw);
			pstmt = conn.prepareStatement(sql);			
			pstmt.setInt(1,getNextOrderId());
			pstmt.setInt(2,o.getCustid());
			pstmt.setInt(3,o.getBookid());
			pstmt.setInt(4,o.getSaleprice());		 
			
			re = pstmt.executeUpdate();
		}catch(Exception e) {			
		}finally {			
			try {
				if(conn != null) {
					conn.close();
				}if(pstmt != null) {
					pstmt.close();
				}				
			}catch(Exception e) {				
			}
		}		
		return re;
	}
}
