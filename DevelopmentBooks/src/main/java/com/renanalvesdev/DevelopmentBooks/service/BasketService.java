package com.renanalvesdev.DevelopmentBooks.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.renanalvesdev.DevelopmentBooks.dto.BasketDTO;
import com.renanalvesdev.DevelopmentBooks.dto.BasketItemDTO;
import com.renanalvesdev.DevelopmentBooks.enums.Book;
import com.renanalvesdev.DevelopmentBooks.model.BasketItem;

@Service
public class BasketService {
	
	  private Map<Integer, BigDecimal> discountTablePerDifferentBooks=Map.of(
		    2, new BigDecimal("0.05"),
		    3, new BigDecimal("0.10"),
		    4, new BigDecimal("0.20"),
		    5, new BigDecimal("0.25")
		);
      
      
	public BigDecimal calculateTotal(BasketDTO basketDTO) {
		
		System.out.println("\n\n\n##### Starting calculating total from basket: " + basketDTO + " ###########");
		groupItensBySameTitleAndSumQuantity(basketDTO);
		
		List<BasketItem> basketItems = convertDtoToBasketItem(basketDTO);
		List<Book> differentBooksGroup = new ArrayList<Book>();
		
		BigDecimal total = new BigDecimal("0.00");
		BigDecimal totalDifferentBooksPerRound = new BigDecimal("0.00");
		int round = 0 ;
		
		while(basketItems.stream().anyMatch(item -> item.getQuantity() > 0)) {
			round++;
			System.out.println("\n ROUND " + round + " ");
			int differentBooks = 0;
			
			for (BasketItem basketItem : basketItems) {
				if(basketItem.getQuantity() > 0) {
					basketItem.setQuantity(basketItem.getQuantity() - 1);
					differentBooksGroup.add(basketItem.getBook());
					totalDifferentBooksPerRound=totalDifferentBooksPerRound.add(basketItem.getBook().getPrice());
					differentBooks++;
				}
			}
			
			totalDifferentBooksPerRound = calculateTotalDifferentBooksWithDiscount(totalDifferentBooksPerRound, differentBooks);
			total = total.add(totalDifferentBooksPerRound);
			System.out.println(differentBooksGroup + " -> " + totalDifferentBooksPerRound + "USD");
			differentBooksGroup.clear();
			totalDifferentBooksPerRound = new BigDecimal("0.00");
		}
		
		System.out.println("\nTotal Basket: " + total);
		return total;
		
	}
	
	private BigDecimal calculateTotalDifferentBooksWithDiscount(BigDecimal total, int differentBooks) {
	     BigDecimal discount = discountTablePerDifferentBooks.getOrDefault(differentBooks, new BigDecimal("0.00"));
	     System.out.println("Different books on the round: " + differentBooks);
	     System.out.println("Selected discount: " + discount);
	     BigDecimal percentageApplied = BigDecimal.ONE.subtract(discount);
	     return total.multiply(percentageApplied);
		
	}
	
	private List<BasketItem> convertDtoToBasketItem(BasketDTO basketDTO) {
		return basketDTO
				.getBasketItensDTO()
				.stream()
				.map(basketItemDTO -> 
					new BasketItem(basketItemDTO.getQuantity(), Book.getByTitle(basketItemDTO.getBookName()))
				).collect(Collectors.toList());
	}
	
	private void groupItensBySameTitleAndSumQuantity(BasketDTO basketDTO) {
		  Map<String, Integer> groupedByNameWithSumQuantity = basketDTO
					.getBasketItensDTO().stream()
					.collect(Collectors
							.groupingBy(BasketItemDTO::getBookName,
							Collectors.summingInt(BasketItemDTO::getQuantity))
					);
			
			List<BasketItemDTO> groupedByNameWithSumQuantityToList = groupedByNameWithSumQuantity.entrySet().stream()
					.map(entry -> new BasketItemDTO(entry.getKey(), entry.getValue()))
					.collect(Collectors.toList());
			
			basketDTO.setBasketItensDTO(groupedByNameWithSumQuantityToList);
			
	}  	
	
}
