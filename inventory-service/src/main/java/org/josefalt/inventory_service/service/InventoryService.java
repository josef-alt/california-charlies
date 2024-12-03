package org.josefalt.inventory_service.service;

import java.util.List;

import org.josefalt.inventory_service.dto.InventoryResponse;
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

	/**
	 * Determine if multiple vehicles are in stock
	 * 
	 * @param units list of unique identifiers
	 * @return list of stock responses
	 */
	@Transactional(readOnly = true)
	public List<InventoryResponse> bulkQuery(List<String> units) {
		return repository.findByUnitIn(units)
				.stream()
				.map(inv -> InventoryResponse.builder().unit(inv.getUnit()).inStock(inv.getQuantity() > 0).build())
				.toList();
	}
}
