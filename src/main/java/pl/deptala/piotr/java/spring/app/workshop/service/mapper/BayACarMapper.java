package pl.deptala.piotr.java.spring.app.workshop.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.deptala.piotr.java.spring.app.workshop.repository.entity.BayACarEntity;
import pl.deptala.piotr.java.spring.app.workshop.repository.entity.CarEntity;
import pl.deptala.piotr.java.spring.app.workshop.web.model.BayACarModel;
import pl.deptala.piotr.java.spring.app.workshop.web.model.CarModel;


import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class BayACarMapper {
    private static final Logger LOGGER = Logger.getLogger(BayACarMapper.class.getName());

    public BayACarEntity from(BayACarModel bayACarModel) {
        LOGGER.info("from()");
        ModelMapper modelMapper = new ModelMapper();
        BayACarEntity bayACarEntity = modelMapper.map(bayACarModel, BayACarEntity.class);
        LOGGER.info("from(...)" + bayACarEntity);
        return bayACarEntity;
    }

    public BayACarModel from(BayACarEntity bayACarEntity) {
        LOGGER.info("from(" + bayACarEntity + ")");
        ModelMapper modelMapper = new ModelMapper();
        BayACarModel bayACarModel = modelMapper.map(bayACarEntity, BayACarModel.class);
        LOGGER.info("from(...) = " + bayACarModel);
        return bayACarModel;
    }

    public List<BayACarModel> fromEntities(List<BayACarEntity> carEntities) {
        LOGGER.info("fromEntities(" + carEntities + ")");
        List<BayACarModel> bayACarModels = carEntities.stream()
                .map(this::from)
                .collect(Collectors.toList());
        LOGGER.info("fromEntities(...) = " + bayACarModels);
        return bayACarModels;
    }

    public List<BayACarEntity> fromModels(List<BayACarModel> bayACarModels) {
        LOGGER.info("fromModels(" + bayACarModels + ")");
        List<BayACarEntity> bayACarEntities = bayACarModels.stream()
                .map(this::from)
                .collect(Collectors.toList());
        LOGGER.info("fromModels(...) = " + bayACarEntities);
        return bayACarEntities;
    }
}
