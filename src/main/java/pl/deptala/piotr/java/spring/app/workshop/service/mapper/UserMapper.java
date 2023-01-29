package pl.deptala.piotr.java.spring.app.workshop.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.deptala.piotr.java.spring.app.workshop.repository.entity.UserEntity;
import pl.deptala.piotr.java.spring.app.workshop.web.model.UserModel;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    private static final Logger LOGGER = Logger.getLogger(UserMapper.class.getName());

    public UserEntity from(UserModel userModel) {
        LOGGER.info("from()");
        ModelMapper modelMapper = new ModelMapper();
        UserEntity userEntity = modelMapper.map(userModel, UserEntity.class);
        LOGGER.info("from(...)" + userEntity);
        return userEntity;
    }

    public UserModel from(UserEntity userEntity) {
        LOGGER.info("from(" + userEntity + ")");
        ModelMapper modelMapper = new ModelMapper();
        UserModel userModel = modelMapper.map(userEntity, UserModel.class);
        LOGGER.info("from(...) = " + userModel);
        return userModel;
    }

    public List<UserModel> fromEntities(List<UserEntity> userEntities) {
        LOGGER.info("fromEntities(" + userEntities + ")");
        List<UserModel> userModels = userEntities.stream()
                .map(this::from)
                .collect(Collectors.toList());
        LOGGER.info("fromEntities(...) = " + userModels);
        return userModels;
    }

    public List<UserEntity> fromModels(List<UserModel> userModels) {
        LOGGER.info("fromModels(" + userModels + ")");
        List<UserEntity> userEntities = userModels.stream()
                .map(this::from)
                .collect(Collectors.toList());
        LOGGER.info("fromModels(...) = " + userEntities);
        return userEntities;
    }
}
