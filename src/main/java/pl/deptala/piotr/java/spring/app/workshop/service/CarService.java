package pl.deptala.piotr.java.spring.app.workshop.service;

import org.springframework.stereotype.Service;
import pl.deptala.piotr.java.spring.app.workshop.repository.CarRepository;
import pl.deptala.piotr.java.spring.app.workshop.repository.entity.CarEntity;
import pl.deptala.piotr.java.spring.app.workshop.service.mapper.CarMapper;
import pl.deptala.piotr.java.spring.app.workshop.web.model.CarModel;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class CarService {
    private static final Logger LOGGER = Logger.getLogger(CarService.class.getName());

    private CarRepository carRepository;
    private CarMapper carMapper;

    public CarService(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    // C - create
    public CarModel create(CarModel carModel) {
        LOGGER.info("create(" + carModel + ")");
        CarEntity carEntity = new CarEntity();
        carEntity.setId(carModel.getId());
        carEntity.setBrand(carModel.getBrand());
        carEntity.setColor(carModel.getColor());

        CarEntity savedCarEntity = carRepository.save(carEntity);

//        CarModel createdCarModel = new CarModel();
//        createdCarModel.setId(savedCarEntity.getId());
//        createdCarModel.setBrand(savedCarEntity.getBrand());
//        createdCarModel.setColor(savedCarEntity.getColor());
        CarModel mappedCarModel = carMapper.mapCarEntity(savedCarEntity);
        LOGGER.info("create(...) = " + mappedCarModel);
        return mappedCarModel;
    }

    // R - read
    public CarModel read(Long id) {
        Optional<CarEntity> optionalCarEntity = carRepository.findById(id);
        CarEntity carEntity = optionalCarEntity.orElseThrow();

//        CarModel readCarModel = new CarModel();
//        readCarModel.setId(carEntity.getId());
//        readCarModel.setBrand(carEntity.getBrand());
//        readCarModel.setColor(carEntity.getColor());
        CarModel carModel = carMapper.mapCarEntity(carEntity);
        return carModel;
    }

    // U - update
    public void update() {
    }

    // D - delete
    public void delete() {
    }

    // L - list
    public void list() {
    }
}
