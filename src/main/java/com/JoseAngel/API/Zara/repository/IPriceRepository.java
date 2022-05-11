package com.JoseAngel.API.Zara.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.JoseAngel.API.Zara.entity.PricesEntity;

public interface IPriceRepository extends JpaRepository<PricesEntity, Long>{

	/**
	 * Get a price list of a product
	 * @param date date to search
	 * @param productId product Id
	 * @param brandId brand Id
	 * @return price list of a product
	 */
	@Query(value = "SELECT P "
				+ " FROM PricesEntity P "
				+ " WHERE P.startDate <= (:#{#date}) "
				+ " AND P.endDate >= (:#{#date}) "
				+ " AND P.productId = (:#{#productId}) "
				+ " AND P.brand.brandId = (:#{#brandId})")
	List<PricesEntity> getProductPrice(@Param("date") LocalDateTime date, @Param("productId") Long productId, @Param("brandId") Long brandId);
}
