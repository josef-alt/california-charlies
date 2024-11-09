package org.josefalt.inventory_service.controller;

import org.josefalt.inventory_service.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

/**
 * Handle inventory queries
 */

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

	/**
	 * Provide access to required services through constructor injection
	 */
	private InventoryService service;

	/**
	 * Check availability of vehicle based on unit number.
	 * 
	 * @param unit unique product number
	 * @return true if the requested vehicle is in stock
	 */
	@GetMapping("/{unit}")
	@ResponseStatus(code = HttpStatus.OK)
	public boolean isInStock(@PathVariable("unit") String unit) {
		return service.isInStock(unit);
	}
}
