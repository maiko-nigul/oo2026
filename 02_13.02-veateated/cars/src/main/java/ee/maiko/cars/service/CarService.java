package ee.maiko.cars.service;

import ee.maiko.cars.entity.Car;
import org.springframework.stereotype.Service;

import java.time.Year;

@Service
public class CarService {
    public  void validate(Car cars){
        if (cars.getId() != null) {
            throw new RuntimeException("New car record cannot have a pre-defined ID.");
        }
        if (cars.getBrand() == null || cars.getBrand().isBlank()) {
            throw new RuntimeException("Car brand is required and cannot be empty.");
        }

        if (cars.getModel() == null || cars.getModel().isBlank()) {
            throw new RuntimeException("Car model is required and cannot be empty.");
        }

        if (cars.getProducedYear() > Year.now().getValue()) {
            throw new RuntimeException("Production year cannot be in the future.");
        }

        if (!cars.getBrand().matches("^[a-zA-Z\\s-]+$")) {
            throw new RuntimeException("Car brand must contain only letters, spaces, or hyphens.");
        }
    }
}
