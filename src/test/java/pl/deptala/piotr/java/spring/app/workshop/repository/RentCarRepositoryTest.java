package pl.deptala.piotr.java.spring.app.workshop.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.deptala.piotr.java.spring.app.workshop.repository.entity.RentCarEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RentCarRepositoryTest {

    @Autowired
    private RentCarRepository rentCarRepository;

    @Test
    void create (){
        // Given
        RentCarEntity carEntity = new RentCarEntity();
        carEntity.setCar("Skoda");
        carEntity.setRentTime(555);

        // When
        RentCarEntity savedRentCarEntity = rentCarRepository.save(carEntity);
        // Then
        Assertions.assertNotNull(savedRentCarEntity,"savedRentCarEntity is NULL");
    }
}