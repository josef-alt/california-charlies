package org.josefalt.car_service.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data transfer object for Car responses
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarResponse {
	private String id;
	private String model;
	private String description;
	private BigDecimal price;
}
