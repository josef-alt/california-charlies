package org.josefalt.inventory_service.service;

import org.josefalt.inventory_service.repository.InventoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

/**
 * Handle inventory query implementation
 */

@Service
@RequiredArgsConstructor
public class InventoryService {

	/**
	 * Connect to repository through constructor
	 */
	private final InventoryRepository repository;

	/**
	 * Determine if a certain vehicle is in stock.
	 * 
	 * @param unit unique identifier for vehicle type.
	 * @return true if the vehicle is in stock
	 */
	@Transactional(readOnly = true)
	public boolean isInStock(String unit) {
		return repository.findByUnit(unit).isPresent();
	}
}
