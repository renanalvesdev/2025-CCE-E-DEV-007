package com.renanalvesdev.DevelopmentBooks.service.exception;

public class BookNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookNotFoundException(String title) {
		super("No book found with title: "+title);
	}
}
