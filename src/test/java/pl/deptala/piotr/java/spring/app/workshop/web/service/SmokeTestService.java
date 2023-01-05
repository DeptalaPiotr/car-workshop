package pl.deptala.piotr.java.spring.app.workshop.web.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.deptala.piotr.java.spring.app.workshop.web.ServiceController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SmokeTestService {

    @Autowired
    private ServiceController serviceController;

    @Test
    public void serviceController() throws Exception{
        assertThat(serviceController).isNotNull();
    }
}
