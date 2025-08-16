package com.renanalvesdev.DevelopmentBooks.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renanalvesdev.DevelopmentBooks.dto.BasketDTO;
import com.renanalvesdev.DevelopmentBooks.service.BasketService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/basket")
public class BasketController {

	
	@Autowired
    private BasketService basketService;
	
	@PostMapping("/calculate")
    public ResponseEntity<BigDecimal> calculateTotal(@RequestBody @Valid BasketDTO basket) {
        BigDecimal total = basketService.calculateTotal(basket);
        return ResponseEntity.ok(total);
    }
}
