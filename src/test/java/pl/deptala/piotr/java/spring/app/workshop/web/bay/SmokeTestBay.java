package pl.deptala.piotr.java.spring.app.workshop.web.bay;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.deptala.piotr.java.spring.app.workshop.web.BayACarController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SmokeTestBay {

    @Autowired
    private BayACarController bayACarController;


    @Test
    public void bayCarController() throws Exception {
        assertThat(bayACarController).isNotNull();
    }
}
