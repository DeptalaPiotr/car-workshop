package pl.deptala.piotr.java.spring.app.workshop.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.deptala.piotr.java.spring.app.workshop.repository.entity.UserEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void create() {
        // Given
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("user");
        userEntity.setPassword(passwordEncoder.encode("password"));

        // When
        UserEntity savedUser = userRepository.save(userEntity);

        // Then
        Assertions.assertNotNull(savedUser, "savedUserEntity is NULL");
    }
}