package pl.deptala.piotr.java.spring.app.workshop.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.deptala.piotr.java.spring.app.workshop.repository.entity.ServiceEntity;
import pl.deptala.piotr.java.spring.app.workshop.web.model.ServiceModel;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ServiceMapperTest {
    @Autowired
    private ServiceMapper serviceMapper;

    @Test
    void fromServiceModel() {
        // Given
        ServiceModel serviceModel = new ServiceModel();
        serviceModel.setDate("27.12.2022");
        serviceModel.setName("Tires swap");
        serviceModel.setPrice(49.99);

        // When
        ServiceEntity mappedEntity = serviceMapper.from(serviceModel);

        // Then
        Assertions.assertNotNull(mappedEntity, "mappedEntity is NULL");
    }

    @Test
    void fromServiceEntity() {
        // Given
        ServiceEntity serviceEntity = new ServiceEntity();
        serviceEntity.setDate("28.12.2022");
        serviceEntity.setName("Oil change");
        serviceEntity.setPrice(89.77);

        // When
        ServiceModel mappedModel = serviceMapper.from(serviceEntity);

        // Then
        Assertions.assertNotNull(mappedModel, "mappedModel is NULL");
    }

    @Test
    void fromEntityList() {
        // Given
        List<ServiceEntity> serviceEntityList = new ArrayList<>();

        // When
        List<ServiceModel> serviceModelList = serviceMapper.fromEntities(serviceEntityList);

        // Then
        Assertions.assertNotNull(serviceModelList, "serviceModelList List is NULL");
    }

    @Test
    void fromModelList() {
        // Given
        List<ServiceModel> serviceModelList = new ArrayList<>();

        // When
        List<ServiceEntity> serviceEntityList = serviceMapper.fromModels(serviceModelList);

        // Then
        Assertions.assertNotNull(serviceEntityList, "serviceEntityList List is NULL");
    }
}