package com.renanalvesdev.DevelopmentBooks.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.renanalvesdev.DevelopmentBooks.dto.BasketDTO;
import com.renanalvesdev.DevelopmentBooks.dto.BasketItemDTO;
import com.renanalvesdev.DevelopmentBooks.enums.Book;

@SpringBootTest
public class BasketServiceTest {
	
	@Autowired
	private BasketService basketService;
	
	
	 static Stream<org.junit.jupiter.params.provider.Arguments> totalBasketTestCases() {
	        return Stream.of(
	            org.junit.jupiter.params.provider.Arguments.of(
	             //5 per cent discount
	         new BasketDTO(List.of(
	            		 new BasketItemDTO(Book.CLEAN_CODE.getTitle(),1),
	            		 new BasketItemDTO(Book.CLEAN_CODER.getTitle(), 1))),new BigDecimal("95")),
	           //10 per cent discount
	            org.junit.jupiter.params.provider.Arguments.of( 
	        new BasketDTO(List.of(
	            		 new BasketItemDTO(Book.CLEAN_CODE.getTitle(), 1),
	            		 new BasketItemDTO(Book.CLEAN_CODER.getTitle(), 1),
	            		 new BasketItemDTO(Book.CLEAN_ARCHITECTURE.getTitle(), 1))),new BigDecimal("135")),
	           //20 per cent discount
	            org.junit.jupiter.params.provider.Arguments.of( 
	        new BasketDTO(  List.of(
	            		 new BasketItemDTO(Book.CLEAN_CODE.getTitle(),1),
	            		 new BasketItemDTO(Book.CLEAN_CODER.getTitle(),1),
	            		 new BasketItemDTO(Book.CLEAN_ARCHITECTURE.getTitle(), 1),
	            		 new BasketItemDTO(Book.TEST_DRIVEN_DEVELOPMENT.getTitle(),1))),new BigDecimal("160")),
	    		 
	           //25 per cent discount
	            org.junit.jupiter.params.provider.Arguments.of( 
	        new BasketDTO(   List.of(
	            		 new BasketItemDTO(Book.CLEAN_CODE.getTitle(), 1),
	            		 new BasketItemDTO(Book.CLEAN_CODER.getTitle(), 1),
	            		 new BasketItemDTO(Book.CLEAN_ARCHITECTURE.getTitle(), 1),
	            		 new BasketItemDTO(Book.TEST_DRIVEN_DEVELOPMENT.getTitle(), 1),
	            		 new BasketItemDTO(Book.WORKING_EFFECTIVELY_LEGACY_CODE.getTitle(), 1))),new BigDecimal("187.5")
	            
	        ),
	        
	            //no discount if same books
	            org.junit.jupiter.params.provider.Arguments.of( 
	        new BasketDTO(   List.of(
	            		 new BasketItemDTO(Book.CLEAN_CODE.getTitle(), 1),
	            		 new BasketItemDTO(Book.CLEAN_CODE.getTitle(), 1),
	            		 new BasketItemDTO(Book.CLEAN_CODE.getTitle(), 1),
	            		 new BasketItemDTO(Book.CLEAN_CODE.getTitle(), 1))),new BigDecimal("200.0")
	            
	           )
	       );
	        
	    }
	 
	@ParameterizedTest
	@MethodSource("totalBasketTestCases")
	void shouldCalculateTotalBasket(BasketDTO basketDTO, BigDecimal total) {
		BigDecimal totalBasket = basketService.calculateTotal(basketDTO);
		assertEquals(0, totalBasket.compareTo(total));
      	
	}
	
	@Test
    void shouldThrowBookNotFoundWhenBookIsInvalid() {
        
		BasketDTO basketDTO = new BasketDTO( List.of(new BasketItemDTO("Invalid Book 12345", 1)));

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> basketService.calculateTotal(basketDTO)
        );

        assertEquals("No book found with title: Invalid Book 12345", exception.getMessage());
    }
}
