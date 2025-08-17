package com.renanalvesdev.DevelopmentBooks.service.exception;

public class BookInvalidException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookInvalidException(String title) {
		super("No book found with title: "+title);
	}
}
