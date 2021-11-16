package com.sist.vo;

public class CustomerVO {
	
	private int custid;
	private String name;
	private String addr;
	private String phone;
	public CustomerVO(int custid, String name, String addr, String phone) {
		super();
		this.custid = custid;
		this.name = name;
		this.addr = addr;
		this.phone = phone;
	}
	public CustomerVO() {
		super();
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	

}
