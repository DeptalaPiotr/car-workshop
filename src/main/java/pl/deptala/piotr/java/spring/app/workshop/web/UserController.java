package pl.deptala.piotr.java.spring.app.workshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/cars/user")
public class UserController {

    private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());

      // C - create
         public void create() {
             LOGGER.info("create()");
             LOGGER.info("create(...)");
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
