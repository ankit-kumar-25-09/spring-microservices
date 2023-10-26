package com.model;

public class User {
	private int uId;
	private String uName;
	private String email;
	private String city;
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public User(int uId, String uName, String email, String city) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.email = email;
		this.city = city;
	}
	

}
