package pl.deptala.piotr.java.spring.app.workshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.deptala.piotr.java.spring.app.workshop.repository.CarRepository;
import pl.deptala.piotr.java.spring.app.workshop.repository.entity.CarEntity;
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

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
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
        carModel.setId(randomId.nextLong());
//        carModels.add(carModel);
        CarEntity carEntity = new CarEntity();
        carEntity.setId(carModel.getId());
        carEntity.setBrand(carModel.getBrand());
        carEntity.setColor(carModel.getColor());
        carRepository.save(carEntity);
        return "redirect:/cars";
    }

    // R - read
    @GetMapping(value = "/{id}")
    public String read(
            @PathVariable(name = "id") String id, ModelMap modelMap) { //http://localhost:8080/cars/1
        //public String read(String id,String name) { //http://localhost:8080/cars?id=1&name=Audi
        LOGGER.info("read(" + id + ")");
        CarEntity referenceById = carRepository.getReferenceById(Long.valueOf(id));
        modelMap.addAttribute("readCar", referenceById);
//        for (CarModel carModel : carModels) {
//            System.out.println(carModel);
//            modelMap.addAttribute("readCar", carModel);
//        }
        return "read-car";
    }

    // U - update
    @GetMapping(value = "/update/{id}")
    public String updateView(
            @PathVariable(name = "id") Long id, ModelMap modelMap) {
        LOGGER.info("updateView()" + id + "");
        CarEntity carEntity = carRepository.getReferenceById(Long.valueOf(id));
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
    public String update(CarModel car) {
        LOGGER.info("update(" + car + ")");
        CarEntity carEntity = carRepository.getReferenceById(car.getId());
        carEntity.setBrand(car.getBrand());
        carEntity.setColor(car.getColor());
        carRepository.save(carEntity);
//        for (CarModel carModel : carModels) {
//            if (car.getId().equals(carModel.getId())) {
//                carModel.setBrand(car.getBrand());
//                carModel.setColor(car.getColor());
//            }
//        }

        return "redirect:/cars";
    }

    // D - delete
    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        LOGGER.info("delete(" + id + ")");
//        ListIterator<CarModel> iterator = carModels.listIterator();
        carRepository.deleteById(id);
//        while (iterator.hasNext()) {
//            CarModel car = iterator.next();
//            if (id.equals(car.getId())) {
//                iterator.remove();
//                LOGGER.info("delete(...) = " + car);
//            }
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
// TODO: 18.10.2022
// W każdej metodzie CRUD zastąpić Liste carModels i operacje n niej z użyciem carRepository *