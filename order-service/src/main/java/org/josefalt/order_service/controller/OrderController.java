package org.josefalt.order_service.controller;

import org.josefalt.order_service.dto.OrderRequest;
import org.josefalt.order_service.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

/**
 * Handle order requests
 */

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

	/**
	 * connect to order service through constructor injection
	 */
	private final OrderService service;

	/**
	 * Create {@code Order} and add to database
	 * 
	 * @param request order body
	 */
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void placeOrder(@RequestBody OrderRequest request) {
		service.placeOrder(request);
	}
}
