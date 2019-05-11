package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Car;
import model.User;
import repo.RepoCars;
import repo.RepoUser;

@RestController
@RequestMapping("/v1/rest/cars")
public class CarController {

	
	@Autowired
	private RepoCars repo;
	
	
	@Autowired
	private RepoUser repoUser;
	
	@GetMapping("/all/{token}")
	public Iterable<Car> findAll(@PathVariable("token") String token ){
		User user = repoUser.findByToken(token);
		if(user == null) {
			throw new RuntimeException("SECURITY EXCEPTION");
		}
		return repo.findAll();
	}
	
	@PostMapping("/save/{token}")
	public Car saveCar(@RequestBody Car car, @PathVariable("token") String token ){
		User user = repoUser.findByToken(token);
		if(user == null) {
			throw new RuntimeException("SECURITY EXCEPTION");
		}

		repo.save(car);
		return car;
	}
	
	
	
	
}
