package pl.deptala.piotr.java.spring.app.workshop.service.mapper;

import org.springframework.stereotype.Component;
import pl.deptala.piotr.java.spring.app.workshop.repository.entity.CarEntity;
import pl.deptala.piotr.java.spring.app.workshop.web.CarController;
import pl.deptala.piotr.java.spring.app.workshop.web.model.CarModel;

import java.util.logging.Logger;

@Component
public class CarMapper {
    private static final Logger LOGGER = Logger.getLogger(CarMapper.class.getName());

    public void mapCarModel(CarModel carModel) {
        LOGGER.info("mapCarModel()");

        LOGGER.info("mapCarModel(...)");
    }

    public CarModel mapCarEntity(CarEntity carEntity) {
        LOGGER.info("mapCarEntity()");
        CarModel carModel = new CarModel();
        carModel.setId(carEntity.getId());
        carModel.setBrand(carEntity.getBrand());
        carModel.setColor(carEntity.getColor());
        LOGGER.info("mapCarEntity(...) = " + carModel);
        return carModel;
    }
}
