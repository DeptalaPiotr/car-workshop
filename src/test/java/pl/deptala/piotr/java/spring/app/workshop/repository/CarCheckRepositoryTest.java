package pl.deptala.piotr.java.spring.app.workshop.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.deptala.piotr.java.spring.app.workshop.repository.entity.CarCheckEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarCheckRepositoryTest {

    @Autowired
    private CarCheckRepository carCheckRepository;

    @Test
    void create() {
        // Given
        CarCheckEntity carCheckEntity = new CarCheckEntity();
        carCheckEntity.setCheckList("Lights, Brakes, Oil");
        carCheckEntity.setPrice(157.33);
        // When
        CarCheckEntity savedCheck = carCheckRepository.save(carCheckEntity);
        // Then
        Assertions.assertNotNull(savedCheck,"savedCheck is NULL");
    }
}