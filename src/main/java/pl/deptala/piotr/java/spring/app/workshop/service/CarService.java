package pl.deptala.piotr.java.spring.app.workshop.service;

import org.springframework.stereotype.Service;
import pl.deptala.piotr.java.spring.app.workshop.api.exception.CarNotFoundException;
import pl.deptala.piotr.java.spring.app.workshop.repository.CarRepository;
import pl.deptala.piotr.java.spring.app.workshop.repository.entity.CarEntity;
import pl.deptala.piotr.java.spring.app.workshop.service.mapper.CarMapper;
import pl.deptala.piotr.java.spring.app.workshop.web.model.CarModel;

import java.util.List;
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
    // Serwis zawiera logikę biznesową
    // Operując na instnejecych danych w systemie i danych danych wprowadzonych przez użytkownika
    public CarModel create(CarModel carModel) {
        LOGGER.info("create(" + carModel + ")");
        CarEntity carEntity = carMapper.from(carModel);
        CarEntity savedCarEntity = carRepository.save(carEntity);
        CarModel mappedCarModel = carMapper.from(savedCarEntity);
        LOGGER.info("create(...) = " + mappedCarModel);
        return mappedCarModel;
    }

    // R - read
    public CarModel read(Long id) throws CarNotFoundException {
        LOGGER.info("read(" + id + ")");
        Optional<CarEntity> optionalCarEntity = carRepository.findById(id);
        CarEntity carEntity = optionalCarEntity.orElseThrow(
                () -> new CarNotFoundException("Nie znaleziono samochodu o ID " + id));
        CarModel carModel = carMapper.from(carEntity);
        LOGGER.info("read(...)" + carModel);
        return carModel;
    }

    // U - update
    public CarModel update(CarModel car) {
        LOGGER.info("update(" + car + ")");
        CarEntity updateCar = carMapper.from(car);
        CarEntity saveCarEntity = carRepository.save(updateCar);
        CarModel carModel = carMapper.from(saveCarEntity);
        LOGGER.info("update(...)" + carModel);
        return carModel;
    }

    // D - delete
    public void delete(Long id) throws CarNotFoundException {
        LOGGER.info("delete()" + id);
        Optional<CarEntity> optionalCarEntity = carRepository.findById(id);
        CarEntity carEntity = optionalCarEntity.orElseThrow(
                () -> new CarNotFoundException("Nie znaleziono samochodu o ID " + id)
        );
        carRepository.delete(carEntity);
        LOGGER.info("delete(...)" + carEntity);
    }

    // L - list
    public List<CarModel> list() {
        LOGGER.info("list()");
        List<CarEntity> carsEntities = carRepository.findAll();
        // List<CarEntity> przemapować na List<CarModel>
        List<CarModel> carModels = carMapper.fromEntities(carsEntities);
        LOGGER.info("list(...)" + carModels);
        return carModels;
    }
}
