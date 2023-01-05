package pl.deptala.piotr.java.spring.app.workshop.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SmokeTest {

	@Autowired
	private CarController controller;
	@Autowired
	private BayACarController bayACarController;
	@Autowired
	private ServiceController serviceController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();

	}

	@Test
	public void bayCarController() throws Exception{
		assertThat(bayACarController).isNotNull();
	}

	// Service Smoke Test
	@Test
	public void serviceController() throws Exception{
		assertThat(serviceController).isNotNull();
	}
}