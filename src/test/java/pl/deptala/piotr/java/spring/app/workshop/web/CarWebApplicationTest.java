package pl.deptala.piotr.java.spring.app.workshop.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CarWebApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void given_when_then() throws Exception {
        // Given
        String endPoint = "/cars";

        // When
        ResultActions resultActions = mockMvc.perform(get(endPoint));

        // Then
        resultActions
                .andDo(print())
                .andExpect(status().isOk());
    }
}
