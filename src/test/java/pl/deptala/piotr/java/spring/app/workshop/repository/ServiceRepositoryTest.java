package pl.deptala.piotr.java.spring.app.workshop.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
        serviceEntity.setName("Oil change");
        serviceEntity.setPrice(59.99);
        // When
        serviceRepository.save(serviceEntity);
        // Then

    }
}