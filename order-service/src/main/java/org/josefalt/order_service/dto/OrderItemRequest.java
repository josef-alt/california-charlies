package org.josefalt.order_service.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * transfer object for cart items
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemRequest {
	private long id;
	private String unit;
	private BigDecimal price;
}
