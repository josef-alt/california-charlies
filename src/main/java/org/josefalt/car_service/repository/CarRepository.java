package org.josefalt.car_service.repository;

import org.josefalt.car_service.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Provide application access to MongoDB database
 */
public interface CarRepository extends MongoRepository<Car, String> {

}
