package repo;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.User;

@Repository
public interface RepoUser extends CrudRepository<User, Integer>{

	public User findByUsernameAndPassword(String username, String password);
	public User findByToken(String token);
}
