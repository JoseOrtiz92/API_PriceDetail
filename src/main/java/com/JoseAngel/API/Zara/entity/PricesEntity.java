package com.JoseAngel.API.Zara.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRICES")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PricesEntity implements Serializable {
	
	private static final long serialVersionUID = -3926475187087819428L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "BRAND_ID", nullable = false)
	private BrandEntity brand;
	
	@Column(name = "START_DATE", nullable = false)
	private LocalDateTime startDate;
	
	@Column(name = "END_DATE", nullable = false)
	private LocalDateTime endDate;
	
	@Column(name = "PRICE_LIST", nullable = false)
	private Integer priceList;
	
	@Column(name = "PRODUCT_ID", nullable = false)
	private Long productId;
	
	@Column(name = "PRIORITY", nullable = false)
	private Integer priority;
	
	@Column(name = "PRICE", nullable = false)
	private BigDecimal price;
	
	@Column(name = "CURR", nullable = false)
	private String curr;

}
