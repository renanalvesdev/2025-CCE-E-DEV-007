package com.renanalvesdev.DevelopmentBooks.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class BasketItemDTO {

	@NotBlank
	private String bookName;

	@Positive
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

	@Override
	public String toString() {
		return "BasketItemDTO [bookName=" + bookName + ", quantity=" + quantity + "]";
	}

	
}
