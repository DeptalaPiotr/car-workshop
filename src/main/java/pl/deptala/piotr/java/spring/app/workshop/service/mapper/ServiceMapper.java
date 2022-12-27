package pl.deptala.piotr.java.spring.app.workshop.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.deptala.piotr.java.spring.app.workshop.repository.entity.ServiceEntity;
import pl.deptala.piotr.java.spring.app.workshop.web.model.ServiceModel;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class ServiceMapper  {
    private static final Logger LOGGER = Logger.getLogger(ServiceMapper.class.getName());

    public ServiceEntity from(ServiceModel serviceModel) {
        LOGGER.info("from()");
        ModelMapper modelMapper = new ModelMapper();
        ServiceEntity serviceEntity = modelMapper.map(serviceModel, ServiceEntity.class);
        LOGGER.info("from(...)" + serviceEntity);
        return serviceEntity;
    }

    public ServiceModel from(ServiceEntity serviceEntity) {
        LOGGER.info("from(" + serviceEntity + ")");
        ModelMapper modelMapper = new ModelMapper();
        ServiceModel serviceModel = modelMapper.map(serviceEntity, ServiceModel.class);
        LOGGER.info("from(...) = " + serviceModel);
        return serviceModel;
    }

    public List<ServiceModel> fromEntities(List<ServiceEntity> serviceEntities) {
        LOGGER.info("fromEntities(" + serviceEntities + ")");
        List<ServiceModel> serviceModels = serviceEntities.stream()
                .map(this::from)
                .collect(Collectors.toList());
        LOGGER.info("fromEntities(...) = " + serviceModels);
        return serviceModels;
    }

    public List<ServiceEntity> fromModels(List<ServiceModel> serviceModels) {
        LOGGER.info("fromModels(" + serviceModels + ")");
        List<ServiceEntity> serviceEntities = serviceModels.stream()
                .map(this::from)
                .collect(Collectors.toList());
        LOGGER.info("fromModels(...) = " + serviceEntities);
        return serviceEntities;
    }
}
