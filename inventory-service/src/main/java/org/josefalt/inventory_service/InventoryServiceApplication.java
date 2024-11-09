package org.josefalt.inventory_service;

import org.josefalt.inventory_service.model.Inventory;
import org.josefalt.inventory_service.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	/**
	 * Generate some entries for testing purposes
	 * 
	 * @param repository repository to populate with dummy values
	 * @return supplier
	 */
	@Bean
	public CommandLineRunner generateData(InventoryRepository repository) {
		return args -> {
			Inventory inv1 = new Inventory();
			inv1.setUnit("Izuzu");
			inv1.setQuantity(7);

			Inventory inv2 = new Inventory();
			inv2.setUnit("Model T");
			inv2.setQuantity(1908);

			Inventory inv3 = new Inventory();
			inv3.setUnit("Tzuyu");
			inv3.setQuantity(1);

			repository.save(inv1);
			repository.save(inv2);
			repository.save(inv3);
		};
	}
}
