package pl.deptala.piotr.java.spring.app.workshop.service;

import org.springframework.stereotype.Service;
import pl.deptala.piotr.java.spring.app.workshop.api.exception.ServiceNotFoundException;
import pl.deptala.piotr.java.spring.app.workshop.repository.ServiceRepository;
import pl.deptala.piotr.java.spring.app.workshop.repository.entity.CarEntity;
import pl.deptala.piotr.java.spring.app.workshop.repository.entity.ServiceEntity;
import pl.deptala.piotr.java.spring.app.workshop.service.mapper.ServiceMapper;
import pl.deptala.piotr.java.spring.app.workshop.web.model.CarModel;
import pl.deptala.piotr.java.spring.app.workshop.web.model.ServiceModel;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ServiceService {
    private static final Logger LOGGER = Logger.getLogger(ServiceService.class.getName());

    private ServiceRepository serviceRepository;
    private ServiceMapper serviceMapper;

    public ServiceService(ServiceRepository serviceRepository, ServiceMapper serviceMapper) {
        this.serviceRepository = serviceRepository;
        this.serviceMapper = serviceMapper;
    }

    // C - create
    public ServiceModel create(ServiceModel serviceModel) {
        LOGGER.info("create(" + serviceModel + ")");
        ServiceEntity serviceEntity = serviceMapper.from(serviceModel);
        ServiceEntity savedServiceEntity = serviceRepository.save(serviceEntity);
        ServiceModel mappedServiceModel = serviceMapper.from(savedServiceEntity);
        LOGGER.info("create(...) = " + mappedServiceModel);
        return mappedServiceModel;
    }

    // R - read
    public ServiceModel read(Long id) throws ServiceNotFoundException {
        LOGGER.info("read(" + id + ")");
        Optional<ServiceEntity> optionalServiceEntity = serviceRepository.findById(id);
        ServiceEntity serviceEntity = optionalServiceEntity.orElseThrow(
                () -> new ServiceNotFoundException("Nie znaleziono usługi o ID " + id));
        ServiceModel serviceModel = serviceMapper.from(serviceEntity);
        LOGGER.info("read(...)" + serviceModel);
        return serviceModel;
    }

    // U - update
        public ServiceModel update(ServiceModel serviceModel) {
            LOGGER.info("update(" + serviceModel + ")");
            ServiceEntity updateService = serviceMapper.from(serviceModel);
            ServiceEntity saveCarEntity = serviceRepository.save(updateService);
            ServiceModel mappedServiceModel = serviceMapper.from(saveCarEntity);
            LOGGER.info("update(...)" + mappedServiceModel);
            return mappedServiceModel;
        }


        // D - delete
    public void delete() {
        LOGGER.info("delete()");
        LOGGER.info("delete(...)");
    }

    // L - list
    public void list() {
        LOGGER.info("list()");
        LOGGER.info("list(...)");
    }
}
