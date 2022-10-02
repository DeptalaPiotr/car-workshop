package pl.deptala.piotr.java.spring.app.workshop.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.deptala.piotr.java.spring.app.workshop.repository.entity.BayACarEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BayACarRepositoryTest {

    @Autowired
    private BayACarRepository carRepository;

    @Test
    void create(){
        // Given
        BayACarEntity bayACarEntity = new BayACarEntity();
        bayACarEntity.setCar("Volvo");
        bayACarEntity.setPrice(32199);
        // When
        BayACarEntity savedBayACar = carRepository.save(bayACarEntity);
        // Then
        Assertions.assertNotNull(savedBayACar,"savedBayACar is NULL");
    }
}