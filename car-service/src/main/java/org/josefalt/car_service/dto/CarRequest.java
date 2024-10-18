package org.josefalt.car_service.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data transfer object for Car requests
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarRequest {
	private String model;
	private String description;
	private BigDecimal price;
}
