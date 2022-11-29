package demo.testexample.service;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.testexample.model.CarModel;

import demo.testexample.repository.CarRepository;

@Service
public class CarService {
	@Autowired
	CarRepository carRepository;

	public CarModel postCar(CarModel CarModel) {
		CarModel m = carRepository.save(CarModel);
		return m;
	}

	public List<CarModel> getcars() {
		Iterable<CarModel> findAll = carRepository.findAll();
		return (List<CarModel>) findAll;
	}

	public void deleteCars(Integer id) {
		carRepository.deleteById(id);

	}

	public CarModel updateCar(CarModel carModel, Integer carNo) {
	java.util.Optional<CarModel> findById = carRepository.findById(carNo);
		CarModel carModel2 = findById.get();
		carModel2.setColour(carModel.getColour());
		carModel2.setCarNo(carNo);
		carModel2.setName(carModel.getName());
		CarModel save = carRepository.save(carModel2);
		return save;
	}

}
