package com.JoseAngel.API.Zara.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.JoseAngel.API.Zara.dto.response.ProductPriceResponseDTO;
import com.JoseAngel.API.Zara.entity.PricesEntity;
import com.JoseAngel.API.Zara.mapper.PriceMapper;
import com.JoseAngel.API.Zara.repository.IPriceRepository;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { PriceServiceImpl.class })
@EnableAutoConfiguration
class PriceServiceImplTest {

	private PriceServiceImpl priceService;
	
	@MockBean
	private IPriceRepository priceRepository;
	
	@MockBean
	private PriceMapper priceMapper;
	
	@BeforeEach
	void setUp() {
		priceService = new PriceServiceImpl(priceRepository, priceMapper);
	}
	
	@Test
	void testGetProductPrice() {
		List<PricesEntity> productPrices = new ArrayList<>();
		
		productPrices.add(PricesEntity.builder().curr("EUR").id(1L).productId(35455L)
				.startDate(LocalDateTime.parse("2020-06-14T00:00:00"))
				.endDate(LocalDateTime.parse("2020-12-31T23:59:59")).priority(0).priceList(1)
				.price(new BigDecimal(35.00)).build());
		
		productPrices.add(PricesEntity.builder().curr("EUR").id(1L).productId(35455L)
				.startDate(LocalDateTime.parse("2020-06-14T15:00:00"))
				.endDate(LocalDateTime.parse("2020-06-14T18:30:00")).priority(1).priceList(1)
				.price(new BigDecimal(25.45)).build());
		
		ProductPriceResponseDTO responseMock = ProductPriceResponseDTO.builder().productId(35455L)
				.startDate(LocalDateTime.parse("2020-06-14T15:00:00"))
				.endDate(LocalDateTime.parse("2020-06-14T18:30:00")).priceList(1)
				.price(new BigDecimal(25.45)).build();
		
		when(priceRepository.getProductPrice(any(LocalDateTime.class), anyLong(), anyLong())).thenReturn(productPrices);
		
		when(priceMapper.productPriceEntityToDTO(any(PricesEntity.class))).thenReturn(responseMock);
		
		ProductPriceResponseDTO response = priceService.getProductPrice(LocalDateTime.parse("2020-06-14T10:00:00"), 35455L, 1L);
		
		assertEquals(responseMock.getPrice().floatValue(), response.getPrice().floatValue());
	}

}
