package pl.deptala.piotr.java.spring.app.workshop.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import pl.deptala.piotr.java.spring.app.workshop.repository.entity.CarEntity;
import pl.deptala.piotr.java.spring.app.workshop.repository.entity.ServiceEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ServiceRepositoryTest {

    @Autowired
    private ServiceRepository serviceRepository;

    @Test
    void create() {
        // Given
        ServiceEntity serviceEntity = new ServiceEntity();
        serviceEntity.setPrice(59.99);
        serviceEntity.setDate("27.12.2022");
        serviceEntity.setName("Oil change");
        // When
        serviceRepository.save(serviceEntity);
        // Then

    }

    @Test
    void createNullEntity() {
        // Given
        ServiceEntity serviceEntity = null;
        // When
        // Then
        Assertions.assertThrows(InvalidDataAccessApiUsageException.class, () -> serviceRepository.save(serviceEntity));
    }
}