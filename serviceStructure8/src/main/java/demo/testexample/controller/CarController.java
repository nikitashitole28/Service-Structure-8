package demo.testexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.testexample.model.CarModel;

import demo.testexample.service.CarService;

@RestController
@RequestMapping("/car")
public class CarController {
	
	@Autowired
	CarService carService;

	@PostMapping("/save")
	public CarModel postCar(@RequestBody CarModel carModel) {
		CarModel carModel1 = carService.postCar(carModel);
		return carModel1;
	}

	@GetMapping("/get")
	public List<CarModel> getCars() {
		List<CarModel> carModel1 = carService.getcars();
		return carModel1;
	}

	@DeleteMapping("/delete")
	public String deleteCars(@PathVariable Integer carNo) {
		carService.deleteCars(carNo);
		return "deleted";
	}

	@PutMapping("/save")
	public CarModel updateCar(@RequestBody CarModel carModel) {
		Integer carNo = carModel.getCarNo();
		CarModel carModel1 = carService.updateCar(carModel, carNo);
		return carModel1;
	}

}
