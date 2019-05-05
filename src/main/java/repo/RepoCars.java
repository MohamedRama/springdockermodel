package repo;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.Car;

@Repository
public interface RepoCars extends CrudRepository<Car, Integer>{

}
