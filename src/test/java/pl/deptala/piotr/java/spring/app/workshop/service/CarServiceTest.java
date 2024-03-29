package pl.deptala.piotr.java.spring.app.workshop.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.deptala.piotr.java.spring.app.workshop.api.exception.CarNotFoundException;
import pl.deptala.piotr.java.spring.app.workshop.api.exception.UserNotFoundException;
import pl.deptala.piotr.java.spring.app.workshop.web.model.CarModel;
import pl.deptala.piotr.java.spring.app.workshop.web.model.VinSpecification;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class CarServiceTest {
    @Autowired
    private CarService carService;

    @Test
    void create() throws UserNotFoundException {
        // Given
        CarModel carModel = new CarModel();

        // When
        CarModel createdCarModel = carService.create(carModel);

        // Then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(createdCarModel, "createdCarModel is NULL"),
                () -> Assertions.assertNotNull(createdCarModel.getId(), "createdCarModel ID is NULL"));
    }

    @Test
    void read() throws CarNotFoundException, UserNotFoundException {
        // Given
        CarModel carModel = new CarModel();
        long carId = 888;
        carModel.setId(carId);
        CarModel savedCar = carService.create(carModel);

        // When
        Long savedCarId = savedCar.getId();
        CarModel readCarModel = carService.read(savedCarId);

        // Then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(readCarModel, "readCarModel is NULL"),
                () -> Assertions.assertNotNull(readCarModel.getId(), "readCarModel ID is NULL"));
    }

    @Test
    void readWrongId() throws CarNotFoundException {
        // Given
        CarModel carModel = new CarModel();
        Long carModelId = carModel.getId(); // ID jest nadawane automatycznie

        // When
        // Then
        Assertions.assertThrows(CarNotFoundException.class, () ->
                carService.read(888L));
    }

    @Test
    void update() {
        // Given
        CarModel carModel = new CarModel();
        carModel.setBrand("BMW");
        carModel.setColor("Blue");
        // When
        CarModel updateCarModel = carService.update(carModel);
        // Then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(updateCarModel, "updateCarModel is NULL"),
                () -> Assertions.assertNotNull(updateCarModel.getId(), "updateCarModel ID is NULL"));

    }

    @Test
    void delete() throws CarNotFoundException, UserNotFoundException {
        // Given
        CarModel carModel = new CarModel();
        long id = 4588;
        carModel.setId(id);
        CarModel savedCarModel = carService.create(carModel);

        // When
        Long savedCarModelId = savedCarModel.getId();
        carService.delete(savedCarModelId);

        // Then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(savedCarModel, "deleteCarModel is NULL"),
                () -> Assertions.assertNotNull(savedCarModel.getId(), "deleteCarModel ID is NULL"));
    }

    @Test
    void list() throws UserNotFoundException {
        // Given
        CarModel bmw = new CarModel();
        CarModel fiat = new CarModel();
        carService.create(bmw);
        carService.create(fiat);
        List<CarModel> testedList = new ArrayList<>();
        testedList.add(bmw);
        testedList.add(fiat);

        // When
        List<CarModel> list = carService.list();

        // Then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(list, "list is NULL"));

    }

    @Test
    void vinCheck() throws IOException {
        // Given
        String vin = "1GNALDEK9FZ108495";
        // When
        VinSpecification carVin = carService.vinCheck(vin);
        // Then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(carVin, "Car VIN is NULL"));
    }
}
