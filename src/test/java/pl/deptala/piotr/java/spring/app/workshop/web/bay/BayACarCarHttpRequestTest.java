package pl.deptala.piotr.java.spring.app.workshop.web.bay;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BayACarCarHttpRequestTest {

    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void bayEndpoint() {
        // Given
        String url = "http://localhost:" + port + "/bay";
        String bay = "List Cars to bay";

        // When
        String forObject = testRestTemplate.getForObject(url, String.class);

        // Then
        Assertions
                .assertThat(forObject)
                .contains(bay);
    }
}
