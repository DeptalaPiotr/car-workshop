package pl.deptala.piotr.java.spring.app.workshop.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import pl.deptala.piotr.java.spring.app.workshop.repository.entity.CarEntity;
import pl.deptala.piotr.java.spring.app.workshop.repository.entity.UserEntity;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
//@DataJpaTest
class UserRepositoryIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CarRepository carRepository;

    @Test
    void create() {
        // Given
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("Jacek");
        userEntity.setPassword("1234");

        // When
        UserEntity savedUser = userRepository.save(userEntity);

        // Then
        Assertions.assertNotNull(savedUser, "savedUserEntity is NULL");
    }

    @Test
    @Rollback(value = false)
//    @Transactional
    void carsWhitUser() {
        // Given
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("Marta");
        userEntity.setPassword("1234");

        CarEntity skodaCarEntity = new CarEntity();
        skodaCarEntity.setBrand("Ford");
        skodaCarEntity.setColor("white");

        CarEntity bmwCarEntity = new CarEntity();
        bmwCarEntity.setBrand("Suzuki");
        bmwCarEntity.setColor("Blue");

        // When
        UserEntity savedUser = userRepository.save(userEntity);
        skodaCarEntity.setOwner(savedUser);
        bmwCarEntity.setOwner(savedUser);
        carRepository.save(skodaCarEntity);
        carRepository.save(bmwCarEntity);

        // Then
        Assertions.assertNotNull(savedUser, "savedUserEntity is NULL");
    }

    @Test
    @Rollback(value = false)
//    @Transactional
    void userWhitCars() {
        // Given
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("Max");
        userEntity.setPassword("1234");
//        UserEntity savedUser = userRepository.save(userEntity);

        CarEntity porscheCarEntity = new CarEntity();
        porscheCarEntity.setBrand("Hyundai");
        porscheCarEntity.setColor("white");
//        porscheCarEntity.setOwner(savedUser);

        CarEntity opelCarEntity = new CarEntity();
        opelCarEntity.setBrand("Honda");
        opelCarEntity.setColor("Blue");
//        opelCarEntity.setOwner(savedUser);

        // When
        CarEntity savedPorscheCarEntity = carRepository.save(porscheCarEntity);
        CarEntity savedOpelCarEntity = carRepository.save(opelCarEntity);

//        List<CarEntity> cars = new ArrayList<>();

        userEntity.addCar(savedPorscheCarEntity);
        userEntity.addCar(savedOpelCarEntity);
//        userEntity.setCars(cars);

        UserEntity updatedUserEntity = userRepository.save(userEntity);
        System.out.println("updatedUserEntity: " + updatedUserEntity);

        // Then
        Assertions.assertNotNull(updatedUserEntity, "savedUserEntity is NULL");
    }
}