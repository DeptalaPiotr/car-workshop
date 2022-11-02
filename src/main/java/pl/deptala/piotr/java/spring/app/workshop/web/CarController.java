package pl.deptala.piotr.java.spring.app.workshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.deptala.piotr.java.spring.app.workshop.api.exception.CarNotFoundException;
import pl.deptala.piotr.java.spring.app.workshop.repository.CarRepository;
import pl.deptala.piotr.java.spring.app.workshop.repository.entity.CarEntity;
import pl.deptala.piotr.java.spring.app.workshop.service.CarService;
import pl.deptala.piotr.java.spring.app.workshop.web.model.CarModel;

import java.util.*;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/cars")
public class CarController {

    private static final Logger LOGGER = Logger.getLogger(CarController.class.getName());
    private List<CarModel> carModels = new ArrayList<>();
    private Random randomId = new Random();

    private CarRepository carRepository;
    private CarService carService;

    public CarController(CarRepository carRepository, CarService carService) {
        this.carRepository = carRepository;
        this.carService = carService;
    }

    @GetMapping(value = "/create")
    public String createView() {
        LOGGER.info("createView()");
        return "create-car";
    }

    // C - create
    @PostMapping
    public String create(CarModel carModel) {
        LOGGER.info("create(" + carModel + ")");
        CarModel createdCarModel = carService.create(carModel);
        return "redirect:/cars";
    }

    // R - read
    @GetMapping(value = "/{id}")
    public String read(
            @PathVariable(name = "id") Long id, ModelMap modelMap) throws CarNotFoundException {
        LOGGER.info("read(" + id + ")");
        Optional<CarEntity> optionalCarEntity = carRepository.findById(id);
        CarEntity carEntity = optionalCarEntity.orElseThrow(
                () -> new CarNotFoundException("Nie znaleziono samochodu o ID " + id));
        modelMap.addAttribute("readCar", carEntity);
        return "read-car";
    }

    // U - update
    @GetMapping(value = "/update/{id}")
    public String updateView(
            @PathVariable(name = "id") Long id, ModelMap modelMap) throws CarNotFoundException {
        LOGGER.info("updateView()" + id + "");
        Optional<CarEntity> updateViewOptional = carRepository.findById(id);
        CarEntity carEntity = updateViewOptional.orElseThrow(
                () -> new CarNotFoundException("Nie znaleziono samochodu o ID " + updateViewOptional));
        // TODO: 28.10.2022  zmienić getReferenceById na findById i zastosować optional analogicznie do metody read()
        CarEntity carEntity = carRepository.getReferenceById(id);
        LOGGER.info("Found a car " + carEntity + "");
        modelMap.addAttribute("car", carEntity);
        return "update-car";
//        for (CarModel car : carModels) {
//            if (car.getId().equals(id)) {
//                LOGGER.info("Found a car " + car + "");
//                modelMap.addAttribute("car", car);
//            }
//
//        }
    }


    @PostMapping(value = "/update")
    public String update(CarModel car) throws CarNotFoundException {
        LOGGER.info("update(" + car + ")");
        Optional<CarEntity> updateOptional = carRepository.findById(car.getId());
        CarEntity carEntity = updateOptional.orElseThrow(
                () -> new CarNotFoundException("Car whit ID" + updateOptional + " is not found")
        );
        // TODO: 28.10.2022  zmienić getReferenceById na findById i zastosować optional analogicznie do metody read()
        carEntity.setBrand(car.getBrand());
        carEntity.setColor(car.getColor());
        carRepository.save(carEntity);
//        CarEntity carEntity = carRepository.getReferenceById(car.getId());
//        carEntity.setBrand(car.getBrand());
//        carEntity.setColor(car.getColor());
//        carRepository.save(carEntity);
//        for (CarModel carModel : carModels) {
//            if (car.getId().equals(carModel.getId())) {
//                carModel.setBrand(car.getBrand());
//                carModel.setColor(car.getColor());
//            }
//        }
        carService.update(car);

        return "redirect:/cars";
    }

    // D - delete
    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        LOGGER.info("delete(" + id + ")");
        carRepository.deleteById(id);

//        ListIterator<CarModel> iterator = carModels.listIterator();
//        carRepository.deleteById(id);
//        while (iterator.hasNext()) {
//            CarModel car = iterator.next();
//            if (id.equals(car.getId())) {
//                iterator.remove();
//                LOGGER.info("delete(...) = " + car);
//            }
        carService.delete(id);
        return "redirect:/cars";
    }

    // L - list
    @GetMapping
    public String list(ModelMap modelMap) {
        List<CarEntity> cars = carRepository.findAll();
        modelMap.addAttribute("cars", cars);
        LOGGER.info("list() = " + cars);
        return "list-cars";
    }
}