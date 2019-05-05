package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.User;
import repo.RepoUser;

@RestController
@RequestMapping("/v1/rest/users")
public class UsersController {

	

	
	@Autowired
	private RepoUser repo;
	
	
	@GetMapping("/all")
	public Iterable<User> findAll(){
		return repo.findAll();
	}
	
	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		repo.save(user);
		return user;
	}
	
	/**
	 * Returns a user if login successful, null if login failed
	 * @param username
	 * @param password
	 * @return
	 */
	@PostMapping("/login")
	public User login(@RequestBody LoginForm loginForm) {
		User found = repo.findByUsernameAndPassword(loginForm.getUsername(), loginForm.getPassword());
		return found;
	}
	
	
	
	
}
