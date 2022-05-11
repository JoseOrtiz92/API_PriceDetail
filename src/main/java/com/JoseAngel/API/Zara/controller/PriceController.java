package com.JoseAngel.API.Zara.controller;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.JoseAngel.API.Zara.dto.response.ProductPriceResponseDTO;
import com.JoseAngel.API.Zara.service.interfaces.IPriceService;
import com.JoseAngel.API.Zara.utils.RestConstants;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME)
@RequiredArgsConstructor
public class PriceController {
	
	private final IPriceService priceService;
	
	/**
	 * Get product price detail
	 * @param date date
	 * @param productId product id
	 * @param brandId brand id
	 * @return product price detail
	 */
	@GetMapping(value = "/price/product")
	public ResponseEntity<ProductPriceResponseDTO> getProductPrice(
			@RequestParam(required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) final LocalDateTime date,
			@RequestParam(required = true) final Long productId,
			@RequestParam(required = true) final Long brandId){
		
		final ProductPriceResponseDTO response = priceService.getProductPrice(date, productId, brandId);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
