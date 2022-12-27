package pl.deptala.piotr.java.spring.app.workshop.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.deptala.piotr.java.spring.app.workshop.api.exception.ServiceNotFoundException;
import pl.deptala.piotr.java.spring.app.workshop.repository.entity.ServiceEntity;
import pl.deptala.piotr.java.spring.app.workshop.service.mapper.ServiceMapper;
import pl.deptala.piotr.java.spring.app.workshop.web.model.CarModel;
import pl.deptala.piotr.java.spring.app.workshop.web.model.ServiceModel;

import java.util.ArrayList;
import java.util.List;

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
        // Given
       ServiceModel serviceModel= new ServiceModel();
        serviceModel.setPrice(14.77);
        serviceModel.setName("Service to do");
        serviceModel.setDate("31.12.2022");
        // When
        ServiceModel updateServiceModel = serviceService.update(serviceModel);
        // Then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(updateServiceModel, "updateCarModel is NULL"));
//                () -> Assertions.assertNotNull(updateServiceModel.getId(), "updateCarModel ID is NULL"));

    }

    @Test
    void delete() throws ServiceNotFoundException {
        // Given
        ServiceModel serviceModel = new ServiceModel();
        ServiceEntity mappedEntity = serviceMapper.from(serviceModel);
        Long id = mappedEntity.getId();
        ServiceModel mappedModel = serviceMapper.from(mappedEntity);
        ServiceModel savedCarModel = serviceService.create(mappedModel);

        // When

        serviceService.delete(id);

        // Then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(savedCarModel, "deleteCarModel is NULL"));
//                () -> Assertions.assertNotNull(savedCarModel.getId(), "deleteCarModel ID is NULL"));
    }

    @Test
    void list() {
        // Given
        ServiceModel oil = new ServiceModel();
        ServiceModel filters = new ServiceModel();
        ServiceModel oilModel = serviceService.create(oil);
        ServiceModel filtersModel = serviceService.create(filters);

        List<ServiceModel> testedList = new ArrayList<>();
        testedList.add(oilModel);
        testedList.add(filtersModel);

        // When
        List<ServiceModel> list = serviceService.list();

        // ThenK
        Assertions.assertAll(
                () -> Assertions.assertNotNull(list, "list is NULL"));

    }
}