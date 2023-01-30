package pl.deptala.piotr.java.spring.app.workshop.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.deptala.piotr.java.spring.app.workshop.repository.UserRepository;
import pl.deptala.piotr.java.spring.app.workshop.service.mapper.UserMapper;
import pl.deptala.piotr.java.spring.app.workshop.web.model.UserModel;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;
    private UserMapper userMapper;

    @Test
    void create() {
        // Given
        UserModel userModel = new UserModel();
        userModel.setUsername("Piotr");
        userModel.setPassword("12345");

        // When
        UserModel createdUserModel = userService.create(userModel);

        // Then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(createdUserModel, "createdUserModel is NULL"));
    }

    @Test
    void read() {
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