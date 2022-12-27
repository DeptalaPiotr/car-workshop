package pl.deptala.piotr.java.spring.app.workshop.service;

import org.springframework.stereotype.Service;
import pl.deptala.piotr.java.spring.app.workshop.repository.ServiceRepository;

import java.util.logging.Logger;

@Service
public class ServiceService {
    private static final Logger LOGGER = Logger.getLogger(ServiceService.class.getName());

    private ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

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
