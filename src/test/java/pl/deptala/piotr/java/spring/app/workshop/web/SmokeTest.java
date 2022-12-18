package pl.deptala.piotr.java.spring.app.workshop.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
// TODO: 16.12.2022
// Stworzyć nowy kontroller dla modelu service
// Dodać przynajmniej jeden endpoint
// Dla dopisanego endpoint stworzyć nowe klasy testowe:
// - httpRequestTest
// - webApplicationTest