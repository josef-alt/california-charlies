package org.josefalt.car_service.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Car model
 */

@Document(value = "cars")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Car {
	@Id
	private String id;
	private String model;
	private String description;
	private BigDecimal price;
}
