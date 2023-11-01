package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ShopCart {
	@Id
	private Long userId;
	private Long cartId;
	private Integer totalItems;
	private Double totalCosts;
	private String products;

}
