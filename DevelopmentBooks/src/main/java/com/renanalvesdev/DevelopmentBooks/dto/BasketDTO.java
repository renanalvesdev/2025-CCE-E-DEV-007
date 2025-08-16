package com.renanalvesdev.DevelopmentBooks.dto;

import java.util.List;

public class BasketDTO {
	
	private List<BasketItemDTO> basketItensDTO;

	public BasketDTO(List<BasketItemDTO> basketItensDTO) {
		super();
		this.basketItensDTO = basketItensDTO;
	}

	public List<BasketItemDTO> getBasketItensDTO() {
		return basketItensDTO;
	}

	public void setBasketItensDTO(List<BasketItemDTO> basketItensDTO) {
		this.basketItensDTO = basketItensDTO;
	}
	
	
}
