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
        carService.create(carModel);
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
        LOGGER.info("Found a car " + carEntity + "");
        modelMap.addAttribute("car", carEntity);
        return "update-car";
    }


    @PostMapping(value = "/update")
    public String update(CarModel car) throws CarNotFoundException {
        LOGGER.info("update(" + car + ")");
        CarModel updatedCarModel = carService.update(car);
        LOGGER.info("update(...) = " + updatedCarModel);
        return "redirect:/cars";
    }

    // D - delete
    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        LOGGER.info("delete(" + id + ")");
        carService.delete(id);
        return "redirect:/cars";
    }

    // L - list
    @GetMapping
    public String list(ModelMap modelMap) {
        List<CarModel> cars = carService.list();
        modelMap.addAttribute("cars", cars);
        LOGGER.info("list() = " + cars);
        return "list-cars";
    }
}