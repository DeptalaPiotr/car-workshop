package pl.deptala.piotr.java.spring.app.workshop.web;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.deptala.piotr.java.spring.app.workshop.web.model.CarModel;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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

    @Test
    void createEndPoint() throws Exception {
        // Given
        String endPoint = "/cars";

        CarModel carModel = new CarModel();
        carModel.setBrand("BMW");
        carModel.setColor("White");

        Gson gson = new Gson();
        String carModelJson = gson.toJson(carModel, CarModel.class);

        // When
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .post(endPoint)
                .contentType(MediaType.APPLICATION_JSON).content(carModelJson)
                .accept(MediaType.APPLICATION_JSON));

        System.out.println("Car Model Json " + carModelJson);
//
//        this.mockmvc.perform(put("/someUrl/")
//                        .contentType(MediaType.APPLICATION_JSON).content(json))
//                .andExpect(status().isOk());

        // Then
        resultActions
                .andExpect(status().is3xxRedirection());
//                .andExpect(MockMvcResultMatchers.jsonPath("$.employeeId").exists());
    }

    @Test
    void readEndPoint() throws Exception {
        // Given
        String readUrl = "/cars/{id}";

        // When
        ResultActions resultActions = mockMvc.perform(get(readUrl, 1));

        // Then
        resultActions
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void updateEndPoint() throws Exception {
        // Given
        String updateUrl = "/cars/update/{id}";

        // When
        ResultActions resultActions = mockMvc.perform(get(updateUrl, 1));

        // Then
        resultActions
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteEndPoint() throws Exception {
        // Given
        String deleteUrl = "/cars/delete/{id}";

        // When
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .get(deleteUrl, "1")
                .contentType(MediaType.APPLICATION_JSON));

        // Then
        resultActions
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void vinCheckEndPoint() throws Exception {
        // Given
        String urlTemplate = "/cars/check/vin/{vin}";

        // When
        ResultActions resultActions = mockMvc.perform(get(urlTemplate));

        // Then
        resultActions
                .andDo(print())
                .andExpect(status().isOk());
    }
}

// TODO: 16.12.2022
// Dopisać analogiczny test dla innych endpoint

