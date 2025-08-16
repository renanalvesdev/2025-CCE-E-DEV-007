package com.renanalvesdev.DevelopmentBooks.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.renanalvesdev.DevelopmentBooks.dto.BasketDTO;
import com.renanalvesdev.DevelopmentBooks.dto.BasketItemDTO;
import com.renanalvesdev.DevelopmentBooks.service.BasketService;

@WebMvcTest(BasketController.class)
public class BasketControllerTest {
	 @Autowired
	    private MockMvc mockMvc;

	    @MockBean
	    private BasketService basketService;
	    
	    @Autowired
	    private ObjectMapper objectMapper;

	    @Test
	    void shouldCalculateTotalBasket() throws Exception {
	    	 BasketDTO basket = new BasketDTO(List.of(
	            new BasketItemDTO("Clean Coder", 1),
	            new BasketItemDTO("Clean Code", 1)
	        ));

	        BigDecimal totalBasket = new BigDecimal("150.0");

	        Mockito.when(basketService.calculateTotal(Mockito.any())).thenReturn(totalBasket);

	        mockMvc.perform(post("/basket/calculate")
	        	.contentType(MediaType.APPLICATION_JSON)
	        	.content(objectMapper.writeValueAsString(basket))
	        )
	        .andExpect(status().isOk())
	        .andExpect(content().string("150.0"));
	    }
	    
	    @Test
	    void shouldReturnBadRequestWhenBasketItensDtoIsEmpty() throws Exception {
	    	BasketDTO basket = new BasketDTO(new ArrayList<>());
	    	
	        mockMvc.perform(post("/basket/calculate")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(objectMapper.writeValueAsString(basket)))
	            .andExpect(status().isBadRequest());
	    }

	    @Test
	    void shouldReturnBadRequestWhenAnyBookTitleIsEmpty() throws Exception {
	    	BasketDTO basket = new BasketDTO(List.of(new BasketItemDTO("", 1)));
	    	
	        mockMvc.perform(post("/basket/calculate")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(objectMapper.writeValueAsString(basket)))
	            .andExpect(status().isBadRequest());
	    }
	    
	    @Test
	    void shouldReturnBadRequestWhenAnyBookQuantityIsNotPositive() throws Exception {
	    	BasketDTO basket = new BasketDTO(List.of(new BasketItemDTO("", -1)));
	    	
	        mockMvc.perform(post("/basket/calculate")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(objectMapper.writeValueAsString(basket)))
	            .andExpect(status().isBadRequest());
	    }
}
