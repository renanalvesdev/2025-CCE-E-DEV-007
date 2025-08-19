package com.renanalvesdev.DevelopmentBooks.exception;

public class BookInvalidException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookInvalidException(String title) {
		super("Invalid book with title: "+title);
	}
}
