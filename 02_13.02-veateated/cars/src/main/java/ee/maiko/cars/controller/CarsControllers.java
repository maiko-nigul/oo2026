package ee.maiko.cars.controller;

import ee.maiko.cars.entity.Car;
import ee.maiko.cars.repository.CarsRepository;
import ee.maiko.cars.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarsControllers {

    @Autowired CarsRepository carsRepository;
    @Autowired
    private CarService carService;

    @GetMapping("cars")
    public List<Car> getCars(){
        return carsRepository.findAll();
    }

    @PostMapping("cars")
    public List<Car> addCar(@RequestBody Car car){
        carService.validate(car);
        return carsRepository.findAll();
    }
}
