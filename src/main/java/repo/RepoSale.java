package repo;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.Sale;

@Repository
public interface RepoSale extends CrudRepository<Sale, Integer>{

}
