package com.JoseAngel.API.Zara.service.interfaces;

import java.time.LocalDateTime;

import com.JoseAngel.API.Zara.dto.response.ProductPriceResponseDTO;

public interface IPriceService {

	/**
	 * Get product price detail
	 * @param date date
	 * @param productId product id
	 * @param brandId brand id
	 * @return product price detail
	 */
	ProductPriceResponseDTO getProductPrice(LocalDateTime date, Long productId, Long brandId);
}
