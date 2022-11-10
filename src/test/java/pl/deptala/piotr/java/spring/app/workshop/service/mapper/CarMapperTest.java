package pl.deptala.piotr.java.spring.app.workshop.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.deptala.piotr.java.spring.app.workshop.repository.entity.CarEntity;
import pl.deptala.piotr.java.spring.app.workshop.web.model.CarModel;

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

    @Test
    void fromEntityList() {
        // Given
        List<CarEntity> carEntityList = new ArrayList<>();

        // When
        List<CarModel> carModelList = carMapper.fromList(carEntityList);

        // Then
        Assertions.assertNotNull(carModelList, "converted List is NULL");
    }

    @Test
    void fromModelList1() {
        // Given
        List<CarModel> carModelList = new ArrayList<>();

        // When
        List<CarEntity> carEntityList = carMapper.fromList1(carModelList);

        // Then
        Assertions.assertNotNull(carEntityList, "carEntityList List is NULL");

    }
}