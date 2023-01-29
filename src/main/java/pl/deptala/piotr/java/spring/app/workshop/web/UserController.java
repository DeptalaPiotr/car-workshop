package pl.deptala.piotr.java.spring.app.workshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.deptala.piotr.java.spring.app.workshop.service.UserService;
import pl.deptala.piotr.java.spring.app.workshop.web.model.UserModel;

import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/cars/users")
public class UserController {

    private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // C - create
    @GetMapping(value = "/create")
    public String createView() {
        LOGGER.info("create()");
        return "user/create-user.html";
    }

    @PostMapping()
    public String create(UserModel userModel) {
        LOGGER.info("create(" + userModel + ")");
        UserModel createdUserModel = userService.create(userModel);
        LOGGER.info("create(...) " + createdUserModel);
        return "redirect:/cars";
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
    public void list() {
        LOGGER.info("list()");
        LOGGER.info("list(...)");
    }
}
