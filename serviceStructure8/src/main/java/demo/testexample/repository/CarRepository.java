package demo.testexample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import demo.testexample.model.CarModel; 
@Repository
public interface CarRepository extends CrudRepository<CarModel, Integer>{
	
}

