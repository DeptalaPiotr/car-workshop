package pl.deptala.piotr.java.spring.app.workshop.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.deptala.piotr.java.spring.app.workshop.repository.entity.CarEntity;
import pl.deptala.piotr.java.spring.app.workshop.web.model.CarModel;

@SpringBootTest
class CarMapperTest {

    @Autowired
    private CarMapper carMapper;

    @Test
    void fromCarModel() {
        // Given
        CarModel carModel = new CarModel();
        carModel.setColor("Black");
        carModel.setBrand("BMW");
        // When
        CarEntity mappedEntity = carMapper.from(carModel);
        // Then
        Assertions.assertNotNull(mappedEntity, "mappedEntity is NULL");
    }

    @Test
    void fromCarEntity() {
        // Given
        CarEntity carEntity = new CarEntity();
        carEntity.setColor("White");
        carEntity.setBrand("VW");
        // When
        CarModel mappedModel = carMapper.from(carEntity);
        // Then
        Assertions.assertNotNull(mappedModel, "mappedModel is NULL");
    }
}
// TODO: 03.11.2022
// testy jednoskowe dla