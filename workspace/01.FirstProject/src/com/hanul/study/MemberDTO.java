package com.hanul.study;

import java.io.Serializable;

public class MemberDTO implements Serializable{	//Serializable : 직렬화
	//멤버변수 선언 : 접근제어자 → private
	/*private String name;
	private String id;
	private String pw;
	private int age;
	private String addr;
	*/
	private String name, id, pw, addr;
	private int age;
	
	//디폴트 생성자 메소드 : 빈깡통
	public MemberDTO() {}

	//생성자 메소드 초기화 : 멤버변수를 하나의 객체로 묶어준다 ▶ Source Menu Bar
	public MemberDTO(String name, String id, String pw, int age, String addr) {
		super();
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.age = age;
		this.addr = addr;
	}
	
	//Getters & Setters 메소드 : 멤버변수에 접근하기 위한 메소드 ▶ Source Menu Bar	
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
