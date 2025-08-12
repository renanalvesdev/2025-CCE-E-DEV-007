package com.renanalvesdev.DevelopmentBooks.service;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class BasketServiceTest {
	
	@Autowired
	private BasketService basketService;
	
	@Test
	void shouldCalculateTotalBasket() {
		
		List<BasketItem> basketItens = List.of(
				new BasketItem(2, Book.CLEAN_CODE),
				new BasketItem(2, Book.CLEAN_CODER),
				new BasketItem(2, Book.CLEAN_ARCHITECTURE),
				new BasketItem(1, Book.TEST_DRIVEN_DEVELOPMENT),
				new BasketItem(1, Book.WORKING_EFFECTIVELY_LEGACY_CODE)
				
		);
		
		double totalBasket = basketService.calculateTotal(basketItens);
      	
	}
}
