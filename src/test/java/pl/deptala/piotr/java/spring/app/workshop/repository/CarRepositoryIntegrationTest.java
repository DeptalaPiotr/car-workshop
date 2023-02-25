package pl.deptala.piotr.java.spring.app.workshop.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import pl.deptala.piotr.java.spring.app.workshop.repository.entity.CarEntity;
import pl.deptala.piotr.java.spring.app.workshop.repository.entity.UserEntity;

@SpringBootTest
class CarRepositoryIntegrationTest {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void given_when_then() {

        // Given
        UserEntity owner = new UserEntity();
        owner.setUsername("Tom");
        UserEntity saveOwner = userRepository.save(owner);

        CarEntity carWhitOwner = new CarEntity();
        carWhitOwner.setBrand("Chevrolet");
        carWhitOwner.setColor("Gray");
        carWhitOwner.setOwner(saveOwner);

        // When
        carRepository.save(carWhitOwner);

        // Then
    }
}