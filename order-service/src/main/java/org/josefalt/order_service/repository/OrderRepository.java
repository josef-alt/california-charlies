package org.josefalt.order_service.repository;

import org.josefalt.order_service.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Acts as link to our database
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

}
