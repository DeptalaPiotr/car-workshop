package pl.deptala.piotr.java.spring.app.workshop.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.deptala.piotr.java.spring.app.workshop.repository.entity.CarEntity;
import pl.deptala.piotr.java.spring.app.workshop.web.model.CarModel;

import java.util.logging.Logger;

@Component
public class CarMapper {
    private static final Logger LOGGER = Logger.getLogger(CarMapper.class.getName());

    public void from(CarModel carModel) {
        LOGGER.info("from()");

        LOGGER.info("from(...)");
    }

    public CarModel from(CarEntity carEntity) {
        LOGGER.info("from()");
//        CarModel carModel = new CarModel();
//        carModel.setId(carEntity.getId());
//        carModel.setBrand(carEntity.getBrand());
//        carModel.setColor(carEntity.getColor());

        ModelMapper modelMapper = new ModelMapper();
        CarModel carModel = modelMapper.map(carEntity, CarModel.class);
        LOGGER.info("from(...) = " + carModel);
        return carModel;
    }
    // TODO: 28.10.2022
    // Dodać testy jednoskowe dla obu metod from()
}
