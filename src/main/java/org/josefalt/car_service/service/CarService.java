package org.josefalt.car_service.service;

import org.josefalt.car_service.dto.CarRequest;
import org.josefalt.car_service.model.Car;
import org.josefalt.car_service.repository.CarRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Handles Car operations
 */

@Service
@Slf4j
@RequiredArgsConstructor
public class CarService {
	
	/**
	 * Connect to repository though constructor injection
	 */
	private final CarRepository repository;
	
	/**
	 * Create {@code Car} from request and add to repository.
	 * 
	 * @param request data transfer object representing the desired {@code Car}.
	 */
	public void createCar(CarRequest request) {
		Car car = Car.builder()
				.model(request.getModel())
				.description(request.getDescription())
				.price(request.getPrice())
				.build();
		
		repository.save(car);
		log.info("Saved car {} to database.", car.getId());
	}
}
