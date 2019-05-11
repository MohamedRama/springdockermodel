package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Car;
import model.Sale;
import model.User;
import repo.RepoCars;
import repo.RepoSale;
import repo.RepoUser;

@RestController
@RequestMapping("/v1/rest/db")
public class DbController {

	
	@Autowired
	private RepoCars repoCars;
	@Autowired
	private RepoSale repoSale;
	@Autowired
	private RepoUser repoUser;
	
//	@GetMapping("/populate")
	public String populateDb() {
		
		Car car1 = new Car();
		Car car2 = new Car();
		car1.setBrand("Audi");
		car2.setBrand("Porsche");
		
		User user = new User();
		user.setPassword("1234");
		user.setUsername("admin");
		user.setToken("abcabc");
		
		User user2 = new User();
		user2.setUsername("andy");
		user2.setPassword("1234");
		user2.setToken("xyzxyz");
		
		repoCars.save(car1);
		repoCars.save(car2);
		repoUser.save(user);
		repoUser.save(user2);
		
		Sale sale1 = new Sale();
		sale1.setCar(car1);
		sale1.setTitle("My Sale");
		sale1.setUser(user2);
		repoSale.save(sale1);
		
		return "okay";
	}
	
	
}
