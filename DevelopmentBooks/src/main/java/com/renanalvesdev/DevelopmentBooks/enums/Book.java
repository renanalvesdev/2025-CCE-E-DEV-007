package com.renanalvesdev.DevelopmentBooks.enums;

import java.math.BigDecimal;

public enum Book {
	
	CLEAN_CODE("Clean Code", "Robert Martin", 2008 ,new BigDecimal("50.0")),
	CLEAN_CODER("Clean Coder", "Robert Martin", 2011 ,new BigDecimal("50.0")),
	CLEAN_ARCHITECTURE("Clean Architecture", "Robert Martin", 2017 ,new BigDecimal("50.0")),
	TEST_DRIVEN_DEVELOPMENT("Test Driven Development by Example", "Kent Beck", 2003, new BigDecimal("50.0")),
	WORKING_EFFECTIVELY_LEGACY_CODE("Working Effectively With Legacy Code", "Michael C. Feathers",2004, new BigDecimal("50.0"));
	
	private final String title;
	private final String author;
	private final Integer year;
	private final BigDecimal price;
	
	private Book(String title, String author, Integer year, BigDecimal price) {
		this.title = title;
		this.author = author;
		this.year = year;
		this.price = price;
	}
	
	
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public Integer getYear() {
		return year;
	}
	public BigDecimal getPrice() {
		return price;
	}
	
	
}
