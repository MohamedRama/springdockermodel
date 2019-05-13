package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Sale;
import model.User;
import repo.RepoSale;
import repo.RepoUser;

@RestController
@RequestMapping("/v1/rest/sales")
@CrossOrigin("http://localhost:8080")
public class SalesController {

	

	
	@Autowired
	private RepoSale repo;
	
	@Autowired
	private RepoUser repoUser;
	
	
	@GetMapping("/all/{token}")
	public Iterable<Sale> findAll(@PathVariable("token") String token){
		User user = repoUser.findByToken(token);
		if(user == null) {
			throw new RuntimeException("SECURITY EXCEPTION");
		}
		return repo.findAll();
	}
	
	@PostMapping("/save/{token}")
	public Sale saveSale(@RequestBody Sale sale, @PathVariable("token") String token) {
		User user = repoUser.findByToken(token);
		if(user == null) {
			throw new RuntimeException("SECURITY EXCEPTION");
		}
		repo.save(sale);
		return sale;
	}
	
	
	
	
}
