package pl.deptala.piotr.java.spring.app.workshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.deptala.piotr.java.spring.app.workshop.repository.entity.CarEntity;
import pl.deptala.piotr.java.spring.app.workshop.web.model.CarModel;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/cars")
public class CarController {

    public static final Logger LOGGER = Logger.getLogger(CarController.class.getName());
    public List<CarModel> carModels = new ArrayList<>();

    @GetMapping(value = "/create")
    public String createView() {
        LOGGER.info("createView()");
        return "create-car";
    }

    // C - create
    @PostMapping
    public String create(CarModel carModel) {
        LOGGER.info("create(" + carModel + ")");
        carModels.add(carModel);
        return "redirect:/cars";
       // return "redirect:/notes";
    }

    // R - read
    @GetMapping(value = "/{id}")
    public String read(
            @PathVariable(name = "id") String id) { //http://localhost:8080/cars/1
        //public String read(String id,String name) { //http://localhost:8080/cars?id=1&name=Audi
        LOGGER.info("read(" + id + ")");
        for (CarModel carModel : carModels) {
            System.out.println(carModel);
        }
        return "read-car";
    }

    // U - update
    @GetMapping(value = "/update")
    public String updateView() {
        LOGGER.info("updateView()");
        return "update-car";
    }

    @PutMapping(value = "/update/{id}")
    public String update(
            @PathVariable(name = "id") String id) {
        LOGGER.info("update(" + id + ")");
        return "finish-update";
    }

    // D - delete
    @GetMapping(value = "/delete")
    public String deleteView() {
        LOGGER.info("updateView()");
        return "delete-car";
    }

    public void delete() {
    }

    // L - list
    @GetMapping
    public String list(ModelMap modelMap) {
        LOGGER.info("list() = " + carModels);
        modelMap.addAttribute("cars", carModels);
        return "list-cars";
    }
}
// TODO: 03.10.2022
// Dokończyć implementacje metod CRUD zgodnie z :
// - https://github.com/internet3/crud-rest
// - https://www.juniorjavadeveloper.pl/2020/04/25/pierwsza-klasa-jako-serwis-crud-kod-java-intellij-krok-po-kroku/
// - https://geek.justjoin.it/komunikacja-frontend-www-z-backend-w-javie/