package pl.deptala.piotr.java.spring.app.workshop.web;

import pl.deptala.piotr.java.spring.app.workshop.service.CarService;

import java.util.logging.Logger;

public class
ServiceController {
    private static final Logger LOGGER = Logger.getLogger(ServiceController.class.getName());
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

// TODO: 21.12.2022
// Dla modelu Service CRUD stworzyć wszystkie warstwy (Controller, Service, Mapper, Repository) analogicznie do modelu Car
// Model Service reprezentuje usługe serwisowa np wymiana oleju
// Dodać testy jednoskowe dla wszystkich warstw nalogicznie do modelu Car
// Stworzyć pliki html z widokami dla usług serwisowych
