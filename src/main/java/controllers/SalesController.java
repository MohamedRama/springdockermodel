package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Sale;
import model.User;
import repo.RepoSale;

@RestController
@RequestMapping("/v1/rest/sales")
public class SalesController {

	

	
	@Autowired
	private RepoSale repo;
	
	
	@GetMapping("/all")
	public Iterable<Sale> findAll(){
		return repo.findAll();
	}
	
	@PostMapping("/save")
	public Sale saveSale(@RequestBody Sale sale) {
		repo.save(sale);
		return sale;
	}
	
	
	
	
}
