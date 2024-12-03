package org.josefalt.inventory_service.repository;

import java.util.List;
import java.util.Optional;

import org.josefalt.inventory_service.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Acts as link to database
 */
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
	public Optional<Inventory> findByUnit(String unit);

	public List<Inventory> findByUnitIn(List<String> units);
}
