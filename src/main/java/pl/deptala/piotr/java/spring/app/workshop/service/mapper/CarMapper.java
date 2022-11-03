package pl.deptala.piotr.java.spring.app.workshop.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.deptala.piotr.java.spring.app.workshop.repository.entity.CarEntity;
import pl.deptala.piotr.java.spring.app.workshop.web.model.CarModel;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

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

    public List<CarModel> fromList(List<CarEntity> carEntities) {
        // Stworzyć Liste CarModel
        // Wyciągnąć elementy z listy carEntity
        // użyć mapper do pojedyńczego elementu listy carEntity
        // Zapisać w List<CarModel>
        List<CarModel> carModels = new ArrayList<>();
       for (CarEntity carEntity: carEntities){
           CarModel mappedCarModel = from(carEntity);
           carModels.add(mappedCarModel);
       }
        return carModels;
    }
    // List<CarEntity> przemapować na List<CarModel>
}
