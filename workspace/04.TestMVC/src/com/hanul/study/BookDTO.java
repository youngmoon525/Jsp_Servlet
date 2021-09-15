package com.hanul.study;

import java.io.Serializable;

public class BookDTO implements Serializable{	//직렬화
	//멤버변수 선언
	private String title, name, isbn, company;
	private int cost, qty, price;
	
	//디폴트 생성자 메소드
	public BookDTO() {}

	//생성자 메소드 초기화
	public BookDTO(String title, String name, String isbn, String company, int cost, int qty) {
		super();
		this.title = title;
		this.name = name;
		this.isbn = isbn;
		this.company = company;
		this.cost = cost;
		this.qty = qty;
	}

	//Getters & Setters 메소드
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
