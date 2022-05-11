package com.JoseAngel.API.Zara.service.impl;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.JoseAngel.API.Zara.dto.response.ProductPriceResponseDTO;
import com.JoseAngel.API.Zara.entity.PricesEntity;
import com.JoseAngel.API.Zara.mapper.PriceMapper;
import com.JoseAngel.API.Zara.repository.IPriceRepository;
import com.JoseAngel.API.Zara.service.interfaces.IPriceService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements IPriceService {

	private final IPriceRepository priceRepository;
	private final PriceMapper priceMapper;
	
	@Override
	public ProductPriceResponseDTO getProductPrice(LocalDateTime date, Long productId, Long brandId) {
		
		List<PricesEntity> productPrices = priceRepository.getProductPrice(date, productId, brandId);
		
		if(CollectionUtils.isEmpty(productPrices))
			return ProductPriceResponseDTO.builder().build();
		
		productPrices.sort(Comparator.comparing(PricesEntity::getPriority).reversed());
		
		return priceMapper.productPriceEntityToDTO(productPrices.get(0));
	}

}
