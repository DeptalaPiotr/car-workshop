package pl.deptala.piotr.java.spring.app.workshop.service;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;
import pl.deptala.piotr.java.spring.app.workshop.api.exception.CarNotFoundException;
import pl.deptala.piotr.java.spring.app.workshop.api.exception.UserNotFoundException;
import pl.deptala.piotr.java.spring.app.workshop.repository.CarRepository;
import pl.deptala.piotr.java.spring.app.workshop.repository.UserRepository;
import pl.deptala.piotr.java.spring.app.workshop.repository.entity.CarEntity;
import pl.deptala.piotr.java.spring.app.workshop.repository.entity.UserEntity;
import pl.deptala.piotr.java.spring.app.workshop.service.mapper.CarMapper;
import pl.deptala.piotr.java.spring.app.workshop.web.model.CarModel;
import pl.deptala.piotr.java.spring.app.workshop.web.model.UserModel;
import pl.deptala.piotr.java.spring.app.workshop.web.model.VinSpecification;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Logger;

@Service
@Transactional
public class CarService {
    private static final Logger LOGGER = Logger.getLogger(CarService.class.getName());
    private final ResourceBundle readCredentials = ResourceBundle.getBundle("application");
    private final String apiUrl = readCredentials.getString("rates.api.url");

    private CarRepository carRepository;
    private CarMapper carMapper;
    private UserService userService;
    private UserRepository userRepository;

    public CarService(CarRepository carRepository, CarMapper carMapper, UserService userService, UserRepository userRepository) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    // C - create
    // Serwis zawiera logikę biznesową
    // Operując na instnejecych danych w systemie i danych danych wprowadzonych przez użytkownika
    @Transactional
    public CarModel create(CarModel carModel) throws UserNotFoundException {
        LOGGER.info("create(" + carModel + ")");
        UserModel owner = carModel.getOwner();
        if (owner != null) {
            UserModel userModel = userService.read(owner.getId());
//            carModel.setOwner(userModel);
        }

        CarEntity carEntity = carMapper.from(carModel);
        Optional<UserEntity> optionalUserEntity = userRepository.findById(owner.getId());
        UserEntity userEntity = optionalUserEntity.orElse(new UserEntity());
        carEntity.setOwner(userEntity);

        CarEntity savedCarEntity = carRepository.save(carEntity);
        CarModel mappedCarModel = carMapper.from(savedCarEntity);
        LOGGER.info("create(...) = " + mappedCarModel);
        return mappedCarModel;
    }

    // R - read
    public CarModel read(Long id) throws CarNotFoundException {
        LOGGER.info("read(" + id + ")");
        Optional<CarEntity> optionalCarEntity = carRepository.findById(id);
        CarEntity carEntity = optionalCarEntity.orElseThrow(
                () -> new CarNotFoundException("Nie znaleziono samochodu o ID " + id));
        CarModel carModel = carMapper.from(carEntity);
        LOGGER.info("read(...)" + carModel);
        return carModel;
    }

    // U - update
    public CarModel update(CarModel carModel) {
        LOGGER.info("update(" + carModel + ")");
        CarEntity carEntity = carMapper.from(carModel);

        UserModel owner = carModel.getOwner();
        Optional<UserEntity> optionalUserEntity = userRepository.findById(owner.getId());
        UserEntity userEntity = optionalUserEntity.orElse(new UserEntity());
        carEntity.setOwner(userEntity);

        CarEntity saveCarEntity = carRepository.save(carEntity);
        CarModel mappedCarModel = carMapper.from(saveCarEntity);

        LOGGER.info("update(...)" + mappedCarModel);
        return mappedCarModel;
    }

    // D - delete
    public void delete(Long id) throws CarNotFoundException {
        LOGGER.info("delete(" + id + ")");
        Optional<CarEntity> optionalCarEntity = carRepository.findById(id);
        CarEntity carEntity = optionalCarEntity.orElseThrow(
                () -> new CarNotFoundException("Nie znaleziono samochodu o ID " + id));
        carRepository.delete(carEntity);
        LOGGER.info("delete(...)" + carEntity);
    }

    // L - list
    public List<CarModel> list() {
        LOGGER.info("list()");
        List<CarEntity> carsEntities = carRepository.findAll();
        // List<CarEntity> przemapować na List<CarModel>
        List<CarModel> carModels = carMapper.fromEntities(carsEntities);
        LOGGER.info("list(...)" + carModels);
        return carModels;
    }

    public VinSpecification vinCheck(String vin) throws IOException {
        LOGGER.info("vinCheck()");
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://api.carmd.com/v3.0/decode?vin=" + vin + "")
                .get()
                .addHeader("content-type", "application/json")
                .addHeader("authorization", "MjZiYWViMjgtYTliOC00MTU2LWJlZmYtM2IyMmU4YThlYjQ4")
                .addHeader("partner-token", "eee3532e3a0a4dcc89af7fdc86452850")
                .build();


        Response response = client.newCall(request).execute();
        Gson g = new Gson();
        VinSpecification vinSpecification = g.fromJson(response.body().string(), VinSpecification.class);
        LOGGER.info("vinCheck(...)= " + vinSpecification);
        return vinSpecification;
    }
}
