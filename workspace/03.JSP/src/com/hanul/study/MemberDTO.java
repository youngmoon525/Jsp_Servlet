package com.hanul.study;

import java.io.Serializable;

public class MemberDTO implements Serializable{
	//멤버변수(필드) 선언 : DataBase의 Table의 컬럼(속성, 필드)명과 일치
	private String name, id, pw, addr, tel;
	private int age;
	
	//디폴트 생성자 메소드 : 빈깡통
	public MemberDTO() {}

	//생성자 메소드 초기화 : 멤버변수를 하나의 타입으로 묶어준다
	public MemberDTO(String name, String id, String pw, int age, String addr, String tel) {
		super();
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.age = age;
		this.addr = addr;
		this.tel = tel;
	}

	//Getters & Setters 메소드 : 멤버변수에 접근
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
