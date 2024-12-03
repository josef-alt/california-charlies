package org.josefalt.order_service.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.josefalt.order_service.dto.InventoryResponse;
import org.josefalt.order_service.dto.OrderItemRequest;
import org.josefalt.order_service.dto.OrderRequest;
import org.josefalt.order_service.model.Order;
import org.josefalt.order_service.model.OrderItem;
import org.josefalt.order_service.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Handle car orders
 */

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class OrderService {

	/**
	 * provide connection to database through injection
	 */
	private final OrderRepository repository;

	/**
	 * used for connection with inventory service
	 */
	private final WebClient webClient;
	
	/**
	 * Place orders and save to database
	 * 
	 * @param request cart information for order to be placed
	 */
	public void placeOrder(OrderRequest request) {
		// convert to order
		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		order.setCart(request.getCart().stream().map(dto -> mapToFromDTO(dto)).toList());

		// extract item identifiers
		List<String> units = order.getCart().stream().map(OrderItem::getUnit).toList();

		// check stock using synchronously
		InventoryResponse[] responses = webClient.get()
				.uri("http://localhost:8085/api/inventory", builder -> builder.queryParam("units", units).build())
				.retrieve()
				.bodyToMono(InventoryResponse[].class)
				.block();

		boolean inStock = Arrays.stream(responses).allMatch(resp -> resp.isInStock());
		
		if(inStock) {
			// save order to database
			repository.save(order);
			log.info("Saved order {} to database.", order.getId());
		} else {
			log.error("Product {} is not in stock.", order.getId());
			throw new IllegalArgumentException("Product is not in stock.");
		}
	}

	/**
	 * Helper function for converting from DTOs
	 * 
	 * @param item dto representing an individual item
	 * @return a new order item with data pulled from {@code item}
	 */
	private OrderItem mapToFromDTO(OrderItemRequest item) {
		OrderItem newItem = new OrderItem();
		newItem.setUnit(item.getUnit());
		newItem.setPrice(item.getPrice());

		return newItem;
	}
}
