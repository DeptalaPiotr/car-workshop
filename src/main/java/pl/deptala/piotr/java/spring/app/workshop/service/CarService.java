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
//        CarEntity carEntity = new CarEntity();
//        carEntity.setId(carModel.getId());
//        carEntity.setBrand(carModel.getBrand());
//        carEntity.setColor(carModel.getColor());
        CarEntity model = carMapper.from(carModel);

        // TODO: 28.10.2022
        // Zastąpić powyższy kod implementacją mappera

        CarEntity savedCarEntity = carRepository.save(model);

//        CarModel createdCarModel = new CarModel();
//        createdCarModel.setId(savedCarEntity.getId());
//        createdCarModel.setBrand(savedCarEntity.getBrand());
//        createdCarModel.setColor(savedCarEntity.getColor());
        CarModel mappedCarModel = carMapper.from(savedCarEntity);
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
        CarModel carModel = carMapper.from(carEntity);
        return carModel;
    }

    // TODO: 28.10.2022
    // Dokończyć implementacje update() oraz delete() analogicznie do create() & read()

    // U - update
    public void update(CarModel car) {
        LOGGER.info("update(" + car + ")");
        CarEntity updateCar = carMapper.from(car);
        carRepository.save(updateCar);
        LOGGER.info("update(...)" + updateCar);
    }

    // D - delete
    public void delete(Long id) {
        LOGGER.info("delete()" + id);
        Optional<CarEntity> optionalCarEntity = carRepository.findById(id);
        CarEntity carEntity = optionalCarEntity.orElseThrow();
        carRepository.delete(carEntity);
        LOGGER.info("delete(...)" + carEntity);
    }

    // L - list
    public void list() {
    }
}