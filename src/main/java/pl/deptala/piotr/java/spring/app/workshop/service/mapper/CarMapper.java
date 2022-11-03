package pl.deptala.piotr.java.spring.app.workshop.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.deptala.piotr.java.spring.app.workshop.repository.entity.CarEntity;
import pl.deptala.piotr.java.spring.app.workshop.web.model.CarModel;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class CarMapper {
    private static final Logger LOGGER = Logger.getLogger(CarMapper.class.getName());

    public CarEntity from(CarModel carModel) {
        LOGGER.info("from()");
        ModelMapper modelMapper = new ModelMapper();
        CarEntity carEntity = modelMapper.map(carModel, CarEntity.class);
        LOGGER.info("from(...)" + carEntity);
        return carEntity;
    }

    public CarModel from(CarEntity carEntity) {
        LOGGER.info("from(" + carEntity + ")");
        ModelMapper modelMapper = new ModelMapper();
        CarModel carModel = modelMapper.map(carEntity, CarModel.class);
        LOGGER.info("from(...) = " + carModel);
        return carModel;
    }

    public List<CarModel> fromList(List<CarEntity> carEntities) {
        LOGGER.info("fromList(" + carEntities + ")");
        List<CarModel> carModels = carEntities.stream()
                .map(this::from)
                .collect(Collectors.toList());
        LOGGER.info("fromList(...) = " + carModels);
        return carModels;
    }
}
// TODO: 03.11.2022
// napisać metode, która mapuje List<CarEntity> do List<CarModel>
// testy jednoskowe