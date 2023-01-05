package pl.deptala.piotr.java.spring.app.workshop.web.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServiceHttpRequestTest {

    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void create_endpoint(){
        // Given
        String url = "http://localhost:" + port + "/services/create";
        String updateCar = "Create Service";

        // When
        String forObject = testRestTemplate.getForObject(url, String.class);

        // Then
        Assertions
                .assertThat(forObject)
                .contains(updateCar);
    }

    @Test
    void delete_endpoint(){
        // Given
        String url = "http://localhost:" + port + "/services/delete/1";
        String updateCar = "Delete Service";

        // When
        String forObject = testRestTemplate.getForObject(url, String.class);

        // Then
        Assertions
                .assertThat(forObject)
                .contains(updateCar);
    }
}

