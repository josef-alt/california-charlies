package org.josefalt.inventory_service.repository;

import org.josefalt.inventory_service.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Acts as link to database
 */
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
