package pl.deptala.piotr.java.spring.app.workshop.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.deptala.piotr.java.spring.app.workshop.repository.entity.CarEntity;
import pl.deptala.piotr.java.spring.app.workshop.web.model.CarModel;
import pl.deptala.piotr.java.spring.app.workshop.web.model.UserModel;

import java.util.ArrayList;
import java.util.List;

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

        UserModel userModel = new UserModel();
        userModel.setId(1L);
        userModel.setUsername("Marta");
        userModel.setPassword("1234");

        carModel.setOwner(userModel);

        // When
        CarEntity mappedEntity = carMapper.from(carModel);

        // Then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(mappedEntity, "mapped User Entity is NULL"),
                () -> Assertions.assertNotNull(mappedEntity, "mappedUEntity OWNER is NULL")
        );

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

    @Test
    void fromEntityList() {
        // Given
        List<CarEntity> carEntityList = new ArrayList<>();

        // When
        List<CarModel> carModelList = carMapper.fromEntities(carEntityList);

        // Then
        Assertions.assertNotNull(carModelList, "converted List is NULL");
    }

    @Test
    void fromModelList1() {
        // Given
        List<CarModel> carModelList = new ArrayList<>();

        // When
        List<CarEntity> carEntityList = carMapper.fromModels(carModelList);

        // Then
        Assertions.assertNotNull(carEntityList, "carEntityList List is NULL");

    }
}