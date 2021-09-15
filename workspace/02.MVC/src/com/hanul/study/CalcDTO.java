package com.hanul.study;

import java.io.Serializable;

public class CalcDTO implements Serializable{	//직렬화 : 멤버변수들이 바이트형으로 변환
	private int num1, num2, sum;	//멤버변수(필드) 선언
	
	public CalcDTO() {}	//디폴트 생성자 메소드

	public CalcDTO(int num1, int num2, int sum) {	//생성자 메소드 초기화
		super();
		this.num1 = num1;
		this.num2 = num2;
		this.sum = sum;
	}

	//Getters & Setters 메소드 : 멤버변수에 접근
	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
	
	
}
