package pl.deptala.piotr.java.spring.app.workshop.service;

import org.springframework.stereotype.Service;
import pl.deptala.piotr.java.spring.app.workshop.repository.BayACarRepository;
import pl.deptala.piotr.java.spring.app.workshop.repository.entity.BayACarEntity;
import pl.deptala.piotr.java.spring.app.workshop.service.mapper.BayACarMapper;
import pl.deptala.piotr.java.spring.app.workshop.web.model.BayACarModel;

import java.util.List;
import java.util.logging.Logger;

@Service
public class BayACarService {
    private static final Logger LOGGER = Logger.getLogger(BayACarService.class.getName());

    private BayACarRepository bayACarRepository;
    private BayACarMapper bayACarMapper;


    public BayACarService(BayACarRepository bayACarRepository, BayACarMapper bayACarMapper) {
        this.bayACarRepository = bayACarRepository;
        this.bayACarMapper = bayACarMapper;
    }

    // C - create
    public BayACarModel create(BayACarModel bayACarModel) {
        LOGGER.info("create(" + bayACarModel + ")");
        BayACarEntity bayACarEntity = bayACarMapper.from(bayACarModel);
        BayACarEntity savedEntity = bayACarRepository.save(bayACarEntity);
        BayACarModel mappedModel = bayACarMapper.from(savedEntity);
        LOGGER.info("create(...)" + mappedModel);
        return mappedModel;
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
    public List<BayACarModel> list() {
        LOGGER.info("list()");
        List<BayACarEntity> bayACarList = bayACarRepository.findAll();
        List<BayACarModel> bayACarModels = bayACarMapper.fromEntities(bayACarList);
        LOGGER.info("list(...)" + bayACarModels);
        return bayACarModels;
    }
}
