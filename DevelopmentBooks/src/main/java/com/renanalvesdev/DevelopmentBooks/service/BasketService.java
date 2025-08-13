package com.renanalvesdev.DevelopmentBooks.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.renanalvesdev.DevelopmentBooks.model.BasketItem;

@Service
public class BasketService {
	
	public BigDecimal calculateTotal(List<BasketItem> basketItems) {
		
		//BigDecimal total = new BigDecimal("0.00");
		double totalDouble = 0.00;
		
		while(basketItems.stream().anyMatch(item -> item.getQuantity() > 0)) {
			double discount = 0 ;
			int differentBooks = 0;
			
			for (BasketItem basketItem : basketItems) {
				if(basketItem.getQuantity() > 0) {
					basketItem.setQuantity(basketItem.getQuantity() - 1);
					differentBooks++;
				}
			}
			
			if(differentBooks == 5) {
				discount = 0.25;
			}
			
			if(differentBooks == 4) {
				discount = 0.20;
			}
			
			if(differentBooks == 3) {
				discount = 0.10;
			}
			
			if(differentBooks == 2) {
				discount = 0.05;
			}
			
			totalDouble += (50*differentBooks*(1-discount));
			
		}
		
		return BigDecimal.valueOf(totalDouble);
		
	}
	
}
