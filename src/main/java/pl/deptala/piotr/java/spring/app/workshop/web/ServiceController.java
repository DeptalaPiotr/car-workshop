package pl.deptala.piotr.java.spring.app.workshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.deptala.piotr.java.spring.app.workshop.api.exception.ServiceNotFoundException;
import pl.deptala.piotr.java.spring.app.workshop.service.ServiceService;
import pl.deptala.piotr.java.spring.app.workshop.web.model.ServiceModel;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/services")
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
        return "redirect:/services";
    }

    // R - read
    @GetMapping(value = "/{id}")
    public String read(
            @PathVariable(name = "id") Long id, ModelMap modelMap)
            throws ServiceNotFoundException, IOException {
        LOGGER.info("read(" + id + ")");
        ServiceModel serviceModel = serviceService.read(id);
        modelMap.addAttribute("readService", serviceModel);
        return "";
    }

    // U - update
        @GetMapping(value = "/update/{id}")
        public String updateView(
                @PathVariable(name = "id") Long id, ModelMap modelMap)
            throws ServiceNotFoundException {
            LOGGER.info("updateView()" + id + "");
            ServiceModel serviceModel1 = serviceService.read(id);
            modelMap.addAttribute("car", serviceModel1);
            return "";
    }

    @PostMapping(value = "/update")
    public String update(ServiceModel serviceModel) throws ServiceNotFoundException {
        LOGGER.info("update(" + serviceModel + ")");
        ServiceModel updatedServiceModel = serviceService.update(serviceModel);
        LOGGER.info("update(...) = " + updatedServiceModel);
        return "";
    }

    // D - delete
    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id) throws ServiceNotFoundException{
        LOGGER.info("delete(" + id + ")");
        serviceService.delete(id);
        return "redirect:/services";
    }

    // L - list
    @GetMapping
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
