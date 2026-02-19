package ee.maiko.cars.repository;

import ee.maiko.cars.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarsRepository extends JpaRepository<Car, Long> {
}
