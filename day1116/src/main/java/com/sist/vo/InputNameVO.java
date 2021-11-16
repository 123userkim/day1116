package com.sist.vo;

import java.util.Date;


public class InputNameVO {
	private String cName;
	private String thNumber;
	private String title;
	private Date odate;
	private int seatNumber;
	private int price;
	//극장이름, 상영관.상영관번호, 영화제목, 날짜, 좌석번호, 가격

	public InputNameVO() {
		super();
	}
	public Date getOdate() {
		return odate;
	}
	public void setOdate(Date odate) {
		this.odate = odate;
	}
	public InputNameVO(String cName, String thNumber, String title, Date odate, int seatNumber, int price) {
		super();
		this.cName = cName;
		this.thNumber = thNumber;
		this.title = title;
		this.odate = odate;
		this.seatNumber = seatNumber;
		this.price = price;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getThNumber() {
		return thNumber;
	}
	public void setThNumber(String thNumber) {
		this.thNumber = thNumber;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
