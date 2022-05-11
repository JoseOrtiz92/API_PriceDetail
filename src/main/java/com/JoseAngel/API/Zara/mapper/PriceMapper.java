package com.JoseAngel.API.Zara.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.JoseAngel.API.Zara.dto.response.ProductPriceResponseDTO;
import com.JoseAngel.API.Zara.entity.PricesEntity;

@Mapper(componentModel = "spring")
public interface PriceMapper {

	@Mapping(target = "brandId", source = "entity.brand.brandId")
	ProductPriceResponseDTO productPriceEntityToDTO(PricesEntity entity);
}
