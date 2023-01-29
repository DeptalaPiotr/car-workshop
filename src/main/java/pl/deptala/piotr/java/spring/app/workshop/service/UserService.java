package pl.deptala.piotr.java.spring.app.workshop.service;

import org.springframework.stereotype.Service;
import pl.deptala.piotr.java.spring.app.workshop.api.exception.UserNotFoundException;
import pl.deptala.piotr.java.spring.app.workshop.repository.UserRepository;
import pl.deptala.piotr.java.spring.app.workshop.repository.entity.UserEntity;
import pl.deptala.piotr.java.spring.app.workshop.service.mapper.UserMapper;
import pl.deptala.piotr.java.spring.app.workshop.web.model.UserModel;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UserService {

    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());

    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    // C - create
    public UserModel create(UserModel userModel) {
        LOGGER.info("create(" + userModel + ")");
        UserEntity userEntity = userMapper.from(userModel);
        UserEntity savedUserEntity = userRepository.save(userEntity);
        UserModel mappedUserModel = userMapper.from(savedUserEntity);
        LOGGER.info("create(...) " + mappedUserModel);
        return mappedUserModel;
    }

    // R - read
    public UserModel read(Long id) throws UserNotFoundException {
        LOGGER.info("read(" + id + ")");
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        UserEntity userEntity = optionalUserEntity.orElseThrow(
                () -> new UserNotFoundException("User not found with ID " + id));
        UserModel readUserModel = userMapper.from(userEntity);
        LOGGER.info("read(...) " + readUserModel);
        return readUserModel;
    }

    // U - update
    public UserModel update(UserModel userModel) {
        LOGGER.info("update(" + userModel + ")");
        UserEntity mappedUserEntity = userMapper.from(userModel);
        UserEntity saveUserEntity = userRepository.save(mappedUserEntity);
        UserModel mappedUserMode = userMapper.from(saveUserEntity);
        LOGGER.info("update(...) " + mappedUserMode);
        return mappedUserMode;
    }

    // D - delete
    public void delete(Long id) throws UserNotFoundException {
        LOGGER.info("delete(" + id + ")");
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        UserEntity userEntityToDelete = optionalUserEntity.orElseThrow(
                () -> new UserNotFoundException("User not found with ID " + id));
        userRepository.delete(userEntityToDelete);
        LOGGER.info("delete(...) " + userEntityToDelete);
    }

    // L - list
    public List<UserModel> list() {
        LOGGER.info("list()");
        List<UserEntity> userEntities = userRepository.findAll();
        List<UserModel> userModels = userMapper.fromEntities(userEntities);
        LOGGER.info("list(...) " + userModels);
        return userModels;
    }
}
