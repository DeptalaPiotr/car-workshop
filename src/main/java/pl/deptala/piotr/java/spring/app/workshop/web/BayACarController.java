package pl.deptala.piotr.java.spring.app.workshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.deptala.piotr.java.spring.app.workshop.service.BayACarService;
import pl.deptala.piotr.java.spring.app.workshop.web.model.BayACarModel;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/bay")
public class BayACarController {

    private static final Logger LOGGER = Logger.getLogger(BayACarController.class.getName());

    private BayACarService bayACarService;

    public BayACarController(BayACarService bayACarService) {
        this.bayACarService = bayACarService;
    }

    // C - create
    @GetMapping(value = "/create")
    public String createView() {
        LOGGER.info("createView()");
        return "bay-car";
    }

    @PostMapping
    public String create(BayACarModel bayACarModel) {
        LOGGER.info("create(" + bayACarModel + ")");
        BayACarModel createdBayACarModel = bayACarService.create(bayACarModel);
        LOGGER.info("create(...)" + bayACarModel);
        return "redirect:/bay";
    }

    // R - read
    public void read() {
    }

    // U - update
    public void update() {
    }

    // D - delete
    public void delete() {
    }

    // L - list
    @GetMapping
    public String list(ModelMap modelMap) {
        List<BayACarModel> bayList = bayACarService.list();
        modelMap.addAttribute("bayList", bayList);
        LOGGER.info("list(...)" + bayList);
        return "bay-car-list";
    }
}
