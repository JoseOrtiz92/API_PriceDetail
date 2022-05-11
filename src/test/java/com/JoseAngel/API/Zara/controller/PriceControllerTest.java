package com.JoseAngel.API.Zara.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.JoseAngel.API.Zara.dto.response.ProductPriceResponseDTO;
import com.JoseAngel.API.Zara.service.interfaces.IPriceService;

@SpringBootTest
class PriceControllerTest {

	private PriceController priceController;
	
	@Autowired
	private IPriceService priceService;
	
	@BeforeEach
    void setUp() {
        this.priceController= new PriceController(priceService);
    }
	
	@Test
	void testGetProductPrice1() {
		ResponseEntity<ProductPriceResponseDTO> response = priceController.getProductPrice(LocalDateTime.parse("2020-06-14T10:00:00"), 35455L, 1L);
		System.out.println(response.getBody());
		assertEquals(response.getBody().getPrice().floatValue(), new BigDecimal(35.5).floatValue());
	}
	
	@Test
	void testGetProductPrice2() {
		ResponseEntity<ProductPriceResponseDTO> response = priceController.getProductPrice(LocalDateTime.parse("2020-06-14T16:00:00"), 35455L, 1L);
		System.out.println(response.getBody());
		assertEquals(response.getBody().getPrice().floatValue(), new BigDecimal(25.45).floatValue());
	}
	
	@Test
	void testGetProductPrice3() {
		ResponseEntity<ProductPriceResponseDTO> response = priceController.getProductPrice(LocalDateTime.parse("2020-06-14T21:00:00"), 35455L, 1L);
		System.out.println(response.getBody());
		assertEquals(response.getBody().getPrice().floatValue(), new BigDecimal(35.5).floatValue());
	}
	
	@Test
	void testGetProductPrice4() {
		ResponseEntity<ProductPriceResponseDTO> response = priceController.getProductPrice(LocalDateTime.parse("2020-06-15T10:00:00"), 35455L, 1L);
		System.out.println(response.getBody());
		assertEquals(response.getBody().getPrice().floatValue(), new BigDecimal(30.5).floatValue());
	}
	
	@Test
	void testGetProductPrice5() {
		ResponseEntity<ProductPriceResponseDTO> response = priceController.getProductPrice(LocalDateTime.parse("2020-06-16T21:00:00"), 35455L, 1L);
		System.out.println(response.getBody());
		assertEquals(response.getBody().getPrice().floatValue(), new BigDecimal(38.95).floatValue());
	}

}
