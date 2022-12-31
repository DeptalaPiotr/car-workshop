package pl.deptala.piotr.java.spring.app.workshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.deptala.piotr.java.spring.app.workshop.service.ServiceService;
import pl.deptala.piotr.java.spring.app.workshop.web.model.ServiceModel;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/service")
public class ServiceController {
    private static final Logger LOGGER = Logger.getLogger(ServiceController.class.getName());
    private ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    // C - create
    @GetMapping(value = "/create")
    public String createView() {
        LOGGER.info("createView()");
        return "create-service";
    }
    @PostMapping
    public String create(ServiceModel serviceModel) {
        LOGGER.info("create(" + serviceModel + ")");
        ServiceModel createdServiceModel = serviceService.create(serviceModel);
        LOGGER.info("create(...)=" + createdServiceModel);
        return "service-list";
    }

    // R - read
    public void read() {
        LOGGER.info("read()");
        LOGGER.info("read(...)");
    }

    // U - update
    public void update() {
        LOGGER.info("update()");
        LOGGER.info("update(...)");
    }

    // D - delete
    public void delete() {
        LOGGER.info("delete()");
        LOGGER.info("delete(...)");
    }

    // L - list
    public String list(ModelMap modelMap) {
        List<ServiceModel> services = serviceService.list();
        modelMap.addAttribute("services", services);
        LOGGER.info("list() = " + services);
        return "service-list";
    }

}

// TODO: 21.12.2022
// Dla modelu Service CRUD stworzyć wszystkie warstwy (Controller, Service, Mapper, Repository) analogicznie do modelu Car
// Model Service reprezentuje usługe serwisowa np wymiana oleju
// Dodać testy jednoskowe dla wszystkich warstw nalogicznie do modelu Car
// Stworzyć pliki html z widokami dla usług serwisowych
