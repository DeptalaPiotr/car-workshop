package pl.deptala.piotr.java.spring.app.workshop.web.car;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.deptala.piotr.java.spring.app.workshop.web.BayACarController;
import pl.deptala.piotr.java.spring.app.workshop.web.CarController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private CarController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();

    }
}