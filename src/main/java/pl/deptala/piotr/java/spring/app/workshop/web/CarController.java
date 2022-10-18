package pl.deptala.piotr.java.spring.app.workshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.deptala.piotr.java.spring.app.workshop.web.model.CarModel;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/cars")
public class CarController {

    private static final Logger LOGGER = Logger.getLogger(CarController.class.getName());
    private List<CarModel> carModels = new ArrayList<>();
    private Random randomId = new Random();

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
        carModels.add(carModel);
        return "redirect:/cars";
    }

    // R - read
    @GetMapping(value = "/{id}")
    public String read(
            @PathVariable(name = "id") String id, ModelMap modelMap) { //http://localhost:8080/cars/1
        //public String read(String id,String name) { //http://localhost:8080/cars?id=1&name=Audi
        LOGGER.info("read(" + id + ")");
        for (CarModel carModel : carModels) {
            System.out.println(carModel);
            modelMap.addAttribute("readCar", carModel);
        }
        return "read-car";
    }

    // U - update
    @GetMapping(value = "/update/{id}")
    public String updateView(
            @PathVariable(name = "id") Long id, ModelMap modelMap) {
        LOGGER.info("updateView()" + id + "");
        for (CarModel car : carModels) {
            if (car.getId().equals(id)) {
                LOGGER.info("Found a car " + car + "");
                modelMap.addAttribute("car", car);
            }

        }
        return "update-car";
    }

    @PostMapping(value = "/update")
    public String update(CarModel car) {
        LOGGER.info("update(" + car + ")");
        for (CarModel carModel : carModels) {
            if (car.getId().equals(carModel.getId())) {
                carModel.setBrand(car.getBrand());
                carModel.setColor(car.getColor());
            }
        }
        return "redirect:/cars";
    }

    // D - delete
    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        LOGGER.info("delete(" + id + ")");
        ListIterator<CarModel> iterator = carModels.listIterator();
        while (iterator.hasNext()) {
            CarModel car = iterator.next();
            if (id.equals(car.getId())) {
                iterator.remove();
                LOGGER.info("delete(...) = " + car);
            }
        }
        return "redirect:/cars";
    }

    // L - list
    @GetMapping
    public String list(ModelMap modelMap) {
        LOGGER.info("list() = " + carModels);
        modelMap.addAttribute("cars", carModels);
        return "list-cars";
    }
}
