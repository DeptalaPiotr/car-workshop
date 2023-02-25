package pl.deptala.piotr.java.spring.app.workshop.web;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.deptala.piotr.java.spring.app.workshop.api.exception.UserNotFoundException;
import pl.deptala.piotr.java.spring.app.workshop.service.UserService;
import pl.deptala.piotr.java.spring.app.workshop.web.model.UserModel;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    // C - create
    @GetMapping(value = "/create")
    public String createView() {
        LOGGER.info("create()");
        return "user/create-user.html";
    }

    @PostMapping
    public String create(@ModelAttribute UserModel userModel) {
        LOGGER.info("create(" + userModel + ")");
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        UserModel createdUserModel = userService.create(userModel);
        LOGGER.info("create(...) " + createdUserModel);
//        return "user/list-user.html";
        return "redirect:/users";
    }

    // R - read
    @GetMapping(value = "/{id}")
    public String read(@PathVariable(name = "id") Long id, ModelMap modelMap) throws UserNotFoundException {
        LOGGER.info("read(" + id + ")");
        UserModel readUser = userService.read(id);
        modelMap.addAttribute("readUser", readUser);
        LOGGER.info("read(...) " + readUser);
        return "user/read-user.html";
    }

    // U - update
    @GetMapping(value = "/update/{id}")
    public String updateView(@PathVariable(name = "id") Long id, ModelMap modelMap) throws UserNotFoundException {
        LOGGER.info("updateView(" + id + ")");
        UserModel readUserForUpdate = userService.read(id);
        modelMap.addAttribute("readUserForUpdate", readUserForUpdate);
        LOGGER.info("updateView(...) " + readUserForUpdate);
        return "user/update-user.html";
    }

    @PostMapping(value = "/update")
    public String update(UserModel userModel) throws UserNotFoundException {
        LOGGER.info("update(" + userModel + ")");
        UserModel updateUser = userService.update(userModel);
        LOGGER.info("update(...) " + updateUser);
        return "redirect:/users";
    }

    // D - delete
    public void delete() {
        LOGGER.info("delete()");
        LOGGER.info("delete(...)");
    }

    // L - list
    @GetMapping
    public String list(ModelMap modelMap) {
        LOGGER.info("list()");
        List<UserModel> users = userService.list();
        modelMap.addAttribute("users", users);
        LOGGER.info("list(...) " + users);
        return "user/list-user.html";
    }
}
