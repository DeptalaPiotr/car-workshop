package pl.deptala.piotr.java.spring.app.workshop.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import pl.deptala.piotr.java.spring.app.workshop.repository.entity.CarEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @Test
    void create() {
        // Given
        CarEntity carEntity = new CarEntity();
        carEntity.setBrand("BMW");
        carEntity.setColor("Red");
        // When
        CarEntity savedCarEntity = carRepository.save(carEntity);
        // Then
        Assertions.assertNotNull(savedCarEntity, "savedCarEntity is NULL");
    }

    @Test
    void createNullEntity() {
        // Given
        CarEntity carEntity = null;
        // When
//        CarEntity savedCarEntity = carRepository.save(carEntity);
        // Then
//        Assertions.assertNotNull(savedCarEntity, "savedCarEntity is NULL");
        Assertions.assertThrows(InvalidDataAccessApiUsageException.class, () -> carRepository.save(carEntity));
    }
}
// TODO: 11.11.2022
// https://rapidapi.com/vinfreecheck/api/vin-decoder-1
// analogicznie do projektu currency-conventer użyć zewnętrznego api do weryfikacji nr VIN pojazdu
// napisać test jednoskowy dla CarService sprawdzający czy metoda read() ucza wyjątek dla nie poprawnego ID samochodu