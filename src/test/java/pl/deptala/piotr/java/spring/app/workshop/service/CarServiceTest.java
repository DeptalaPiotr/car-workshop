package pl.deptala.piotr.java.spring.app.workshop.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.deptala.piotr.java.spring.app.workshop.web.model.CarModel;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarServiceTest {
    @Autowired
    private CarService carService;

    @Test
    void create() {
        // Given
        CarModel carModel = new CarModel();

        // When
        CarModel createdCarModel = carService.create(carModel);

        // Then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(createdCarModel, "createdCarModel is NULL"),
                () -> Assertions.assertNotNull(createdCarModel.getId(), "createdCarModel ID is NULL"));
    }
}