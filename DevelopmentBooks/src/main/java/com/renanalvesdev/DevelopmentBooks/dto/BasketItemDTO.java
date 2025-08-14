package com.renanalvesdev.DevelopmentBooks.dto;

public class BasketItemDTO {
	
	
	private String bookName;
	private Integer quantity;
	
	
	public BasketItemDTO(String bookName, Integer quantity) {
		super();
		this.bookName = bookName;
		this.quantity = quantity;
	}
	
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	
}
