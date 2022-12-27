package pl.deptala.piotr.java.spring.app.workshop.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.deptala.piotr.java.spring.app.workshop.api.exception.ServiceNotFoundException;
import pl.deptala.piotr.java.spring.app.workshop.repository.entity.ServiceEntity;
import pl.deptala.piotr.java.spring.app.workshop.service.mapper.ServiceMapper;
import pl.deptala.piotr.java.spring.app.workshop.web.model.ServiceModel;

@SpringBootTest
class ServiceServiceTest {
    @Autowired
    private ServiceService serviceService;
    private ServiceMapper serviceMapper;

    @Test
    void create() {
        // Given
        ServiceModel serviceModel = new ServiceModel();

        // When
        ServiceModel createdServiceModel = serviceService.create(serviceModel);

        // Then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(createdServiceModel, "createdCarModel is NULL"));
//                () -> Assertions.assertNotNull(createdServiceModel.getId(), "createdCarModel ID is NULL"));
    }

    @Test
    void read() throws ServiceNotFoundException {
        // Given
        ServiceModel serviceModel = new ServiceModel();
        ServiceEntity mappedEntity = serviceMapper.from(serviceModel);
        Long id = mappedEntity.getId();
        ServiceModel mappedModel = serviceMapper.from(mappedEntity);
        ServiceModel saveServiceModel = serviceService.create(mappedModel);

        // When
        ServiceModel readModel = serviceService.read(id);

        // Then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(readModel, "readCarModel is NULL"));
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void list() {
    }
}