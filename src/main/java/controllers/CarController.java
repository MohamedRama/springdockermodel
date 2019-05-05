package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Car;
import repo.RepoCars;

@RestController
@RequestMapping("/v1/rest/cars")
public class CarController {

	
	@Autowired
	private RepoCars repo;
	
	
	@GetMapping("/all")
	public Iterable<Car> findAll(){
		return repo.findAll();
	}
	
	@PostMapping("/save")
	public Car saveCar(@RequestBody Car car) {
		repo.save(car);
		return car;
	}
	
	
	
	
}
