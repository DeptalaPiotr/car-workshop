package pl.deptala.piotr.java.spring.app.workshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.deptala.piotr.java.spring.app.workshop.api.exception.CarNotFoundException;
import pl.deptala.piotr.java.spring.app.workshop.service.CarService;
import pl.deptala.piotr.java.spring.app.workshop.web.model.CarModel;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/cars")
public class CarController {

    private static final Logger LOGGER = Logger.getLogger(CarController.class.getName());

    private CarService carService;

    public CarController(CarService carService) {
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
        LOGGER.info("create(...)=" + createdCarModel);
        return "redirect:/cars";
    }

    // R - read
    @GetMapping(value = "/{id}")
    public String read(
            @PathVariable(name = "id") Long id, ModelMap modelMap)
            throws CarNotFoundException {
        LOGGER.info("read(" + id + ")");
        CarModel carModel = carService.read(id);
        modelMap.addAttribute("readCar", carModel);
        return "read-car";
    }

    // U - update
    @GetMapping(value = "/update/{id}")
    public String updateView(
            @PathVariable(name = "id") Long id, ModelMap modelMap)
            throws CarNotFoundException {
        LOGGER.info("updateView()" + id + "");
        CarModel carModel = carService.read(id);
        modelMap.addAttribute("car", carModel);
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