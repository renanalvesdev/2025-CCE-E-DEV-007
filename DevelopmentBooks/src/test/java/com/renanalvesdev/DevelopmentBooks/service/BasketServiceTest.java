package com.renanalvesdev.DevelopmentBooks.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.renanalvesdev.DevelopmentBooks.enums.Book;
import com.renanalvesdev.DevelopmentBooks.model.BasketItem;

@SpringBootTest
public class BasketServiceTest {
	
	@Autowired
	private BasketService basketService;
	
	@Test
	void shouldCalculateTotalBasket() {
		
		List<BasketItem> basketItens = List.of(
				new BasketItem(2, Book.CLEAN_CODE),
				new BasketItem(2, Book.CLEAN_CODER)/*),
				new BasketItem(2, Book.CLEAN_ARCHITECTURE),
				new BasketItem(1, Book.TEST_DRIVEN_DEVELOPMENT),
				new BasketItem(1, Book.WORKING_EFFECTIVELY_LEGACY_CODE)*/
				
		);
		
		BigDecimal totalBasket = basketService.calculateTotal(basketItens);
		assertEquals(0, totalBasket.compareTo(new BigDecimal("190.0")));
      	
	}
}
