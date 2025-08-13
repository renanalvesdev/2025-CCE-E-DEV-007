package com.renanalvesdev.DevelopmentBooks.model;

import com.renanalvesdev.DevelopmentBooks.enums.Book;

public class BasketItem {
	
	private Integer quantity;
	private Book book;
	
	public BasketItem(Integer quantity, Book book) {
		super();
		this.quantity = quantity;
		this.book = book;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	
}
