package com.JoseAngel.API.Zara.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BRAND")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BrandEntity implements Serializable {
	
	private static final long serialVersionUID = -1671277279151539469L;
	
	@Id
	@Column(name = "BRAND_ID")
	private Long brandId;
	
	@Column(name = "BRAND_NAME", nullable = false)
	private String brandName;
	
	@OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, targetEntity = PricesEntity.class)
	private List<PricesEntity> prices;

}
