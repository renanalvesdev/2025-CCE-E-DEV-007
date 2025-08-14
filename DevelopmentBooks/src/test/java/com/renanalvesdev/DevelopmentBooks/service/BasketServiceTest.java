package com.renanalvesdev.DevelopmentBooks.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.renanalvesdev.DevelopmentBooks.enums.Book;
import com.renanalvesdev.DevelopmentBooks.model.BasketItem;

@SpringBootTest
public class BasketServiceTest {
	
	@Autowired
	private BasketService basketService;
	
	
	 static Stream<org.junit.jupiter.params.provider.Arguments> totalBasketTestCases() {
	        return Stream.of(
	            org.junit.jupiter.params.provider.Arguments.of(
	             //5 per cent discount
	             List.of(
	            		 new BasketItem(1, Book.CLEAN_CODE),
	            		 new BasketItem(1, Book.CLEAN_CODER)),new BigDecimal("95")),
	           //10 per cent discount
	            org.junit.jupiter.params.provider.Arguments.of( 
	            List.of(
	            		 new BasketItem(1, Book.CLEAN_CODE),
	            		 new BasketItem(1, Book.CLEAN_CODER),
	            		 new BasketItem(1, Book.CLEAN_ARCHITECTURE)),new BigDecimal("135")),
	           //20 per cent discount
	            org.junit.jupiter.params.provider.Arguments.of( List.of(
	            		 new BasketItem(1, Book.CLEAN_CODE),
	            		 new BasketItem(1, Book.CLEAN_CODER),
	            		 new BasketItem(1, Book.CLEAN_ARCHITECTURE),
	            		 new BasketItem(1, Book.TEST_DRIVEN_DEVELOPMENT)),new BigDecimal("160")),
	    		 
	           //25 per cent discount
	            org.junit.jupiter.params.provider.Arguments.of( List.of(
	            		 new BasketItem(1, Book.CLEAN_CODE),
	            		 new BasketItem(1, Book.CLEAN_CODER),
	            		 new BasketItem(1, Book.CLEAN_ARCHITECTURE),
	            		 new BasketItem(1, Book.TEST_DRIVEN_DEVELOPMENT),
	            		 new BasketItem(1, Book.WORKING_EFFECTIVELY_LEGACY_CODE)),new BigDecimal("187.5")
	            
	        ));
	    }
	 
	@ParameterizedTest
	@MethodSource("totalBasketTestCases")
	void shouldCalculateTotalBasket(List<BasketItem> basketItens, BigDecimal total) {
		BigDecimal totalBasket = basketService.calculateTotal(basketItens);
		assertEquals(0, totalBasket.compareTo(total));
      	
	}
}
