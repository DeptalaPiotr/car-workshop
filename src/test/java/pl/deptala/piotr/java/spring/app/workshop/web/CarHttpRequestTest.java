package pl.deptala.piotr.java.spring.app.workshop.web;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CarHttpRequestTest {

    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void given_when_then() {
        // Given
        String url = "http://localhost:" + port + "/cars";
        String listCarsHtmlFragment = "List Cars";

        // When
        String forObject = testRestTemplate.getForObject(url, String.class);

        // Then
        Assertions.assertThat(forObject).contains(listCarsHtmlFragment);
    }
}
