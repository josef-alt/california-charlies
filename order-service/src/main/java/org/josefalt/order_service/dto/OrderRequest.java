package org.josefalt.order_service.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * transfer object for full order without id
 */

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
	private List<OrderItemRequest> cart;
}
