package org.josefalt.inventory_service.service;

import java.util.ArrayList;
import java.util.List;

import org.josefalt.inventory_service.dto.InventoryResponse;
import org.josefalt.inventory_service.model.Inventory;
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
		List<String> requestCopy = new ArrayList<>(units);
		List<Inventory> found = repository.findByUnitIn(units);
		List<InventoryResponse> results = new ArrayList<>(units.size());

		// convert any responses into Response objects
		for (Inventory inv : found) {
			results.add(InventoryResponse.builder().unit(inv.getUnit()).inStock(inv.getQuantity() > 0).build());

			// remove unit id from copied list
			requestCopy.remove(inv.getUnit());
		}

		// generate Response objects for any invalid ids
		for (String unfound : requestCopy) {
			results.add(InventoryResponse.builder().unit(unfound).inStock(false).build());
		}

		return results;
	}
}
