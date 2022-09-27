package pl.deptala.piotr.java.spring.app.workshop.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.deptala.piotr.java.spring.app.workshop.repository.entity.CarEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @Test
    void create() {
        // Given
        CarEntity carEntity = new CarEntity();
        carEntity.setBrand("BMW");
        carEntity.setColor("Red");
        // When
        CarEntity savedCarEntity = carRepository.save(carEntity);
        // Then
        Assertions.assertNotNull(savedCarEntity, "savedCarEntity is NULL");
    }
}