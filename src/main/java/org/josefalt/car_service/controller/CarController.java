package org.josefalt.car_service.controller;

import org.josefalt.car_service.dto.CarRequest;
import org.josefalt.car_service.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

/**
 * Handles requests
 */

@RestController
@RequestMapping("/api/car")
@RequiredArgsConstructor
public class CarController {

	/**
	 * Inject car service through constructor
	 */
	private final CarService service;

	/**
	 * Create {@code Car} and add to database
	 * 
	 * @param request model containing all the relevant {@code Car} information
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createCar(@RequestBody CarRequest request) {
		service.createCar(request);
	}
}
