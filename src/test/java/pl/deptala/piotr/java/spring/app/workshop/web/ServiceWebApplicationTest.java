package pl.deptala.piotr.java.spring.app.workshop.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import pl.deptala.piotr.java.spring.app.workshop.web.model.ServiceModel;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ServiceWebApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createEndPoint() throws Exception {
        // Given
        String endPoint = "/services";

        ServiceModel serviceModel = new ServiceModel();
        serviceModel.setName("brake replacement");
        serviceModel.setDate("05.01.2023");
        serviceModel.setPrice(278.11);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("name", serviceModel.getName());
        params.add("date", serviceModel.getDate());
//        params.add("price", serviceModel.getPrice());

        // When
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .post(endPoint)
                .params(params)
                .accept(MediaType.APPLICATION_JSON));

        // Then
        resultActions
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void readEndPoint() throws Exception {
        // Given
        String readUrl = "/services/{id}";

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
        String updateUrl = "/services/update/{id}";

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
        String deleteUrl = "/services/delete/{id}";

        // When
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .get(deleteUrl, "1")
                .contentType(MediaType.APPLICATION_JSON));

        // Then
        resultActions
                .andDo(print())
                .andExpect(status().isOk());
    }
}
