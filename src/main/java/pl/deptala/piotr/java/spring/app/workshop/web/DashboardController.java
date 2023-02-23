package pl.deptala.piotr.java.spring.app.workshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
@RequestMapping(value = {"/", "/dashboard"})
public class DashboardController {

    private static final Logger LOGGER = Logger.getLogger(DashboardController.class.getName());


    // C - create
    public void create() {
        LOGGER.info("create()");
        LOGGER.info("create(...)");
    }

    // R - read
    @GetMapping
    public String read() {
        LOGGER.info("read()");
        LOGGER.info("read(...)");
        return "dashboard.html";
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
    public void list() {
        LOGGER.info("list()");
        LOGGER.info("list(...)");
    }
}
