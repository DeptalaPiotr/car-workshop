package pl.deptala.piotr.java.spring.app.workshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.deptala.piotr.java.spring.app.workshop.api.exception.CarNotFoundException;
import pl.deptala.piotr.java.spring.app.workshop.api.exception.UserNotFoundException;
import pl.deptala.piotr.java.spring.app.workshop.repository.UserRepository;
import pl.deptala.piotr.java.spring.app.workshop.repository.entity.UserEntity;
import pl.deptala.piotr.java.spring.app.workshop.service.CarService;
import pl.deptala.piotr.java.spring.app.workshop.web.model.CarModel;
import pl.deptala.piotr.java.spring.app.workshop.web.model.VinSpecification;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/cars")
public class CarController {

    private static final Logger LOGGER = Logger.getLogger(CarController.class.getName());

    private final CarService carService; // zależność
    private final UserRepository userRepository;

    public CarController(CarService carService, UserRepository userRepository) { // wtrzyknięcie zależnosci
        this.carService = carService;
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/create")
    public String createView(ModelMap modelMap) {
        LOGGER.info("createView()");
        List<UserEntity> users = userRepository.findAll();
        modelMap.addAttribute("users", users);
        modelMap.addAttribute("carModel", new CarModel());
        return "car/create-car";
    }

    // C - create
    // Controller sluży do pobierania danych od użytkownika np: http,cli
    // metody w kontrolerze służą do weryfikacji/walidacji danych wprowadzonych przez użytkownika
    // Metody nie powinny zawierać logiki biznesowej
    @PostMapping
    public String create(
            @Valid @ModelAttribute(name = "carModel") CarModel carModel,
            BindingResult bindingResult) throws UserNotFoundException {
        LOGGER.info("create(" + carModel + ")");
        if (bindingResult.hasErrors()) {
            LOGGER.info("Formularz zawiera błędy");
            return "car/create-car";
        }
        CarModel createdCarModel = carService.create(carModel); // delegacja wywołania metody
        LOGGER.info("create(...)=" + createdCarModel);
        return "redirect:/cars";
    }

    // R - read
    @GetMapping(value = "/{id}")
    public String read(
            @PathVariable(name = "id") Long id, ModelMap modelMap)
            throws CarNotFoundException, IOException {
        LOGGER.info("read(" + id + ")");
        CarModel carModel = carService.read(id);
        modelMap.addAttribute("readCar", carModel);
        return "car/read-car";
    }

    // U - update
    @GetMapping(value = "/update/{id}")
    public String updateView(
            @PathVariable(name = "id") Long id, ModelMap modelMap)
            throws CarNotFoundException {
        LOGGER.info("updateView(" + id + ")");
        List<UserEntity> users = userRepository.findAll();
        modelMap.addAttribute("users", users);
        CarModel carModel = carService.read(id);
        modelMap.addAttribute("car", carModel);
        return "car/update-car";
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
    public String delete(@PathVariable(name = "id") Long id) throws CarNotFoundException {
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
        return "car/list-cars";
    }

    // Vin Check
    @GetMapping(value = "/check/vin/{vin}")
    public VinSpecification vinCheck(String vin) throws IOException {
        LOGGER.info("vinCheck()");
        VinSpecification vinSpecification = carService.vinCheck(vin);
        LOGGER.info("vinCheck(...)");
        return vinSpecification;
    }
}