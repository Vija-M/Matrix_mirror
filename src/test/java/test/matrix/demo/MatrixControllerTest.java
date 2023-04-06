package test.matrix.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
@MockitoSettings(strictness = Strictness.LENIENT)
public class MatrixControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void mirror_should_return_mirrored_matrix() throws Exception {
        // Arrange
        List<List<Integer>> matrixValues = Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(5, 6, 7, 8),
                Arrays.asList(9, 10, 11, 12),
                Arrays.asList(13, 14, 15, 16)
        );
        Matrix matrix = new Matrix();
        matrix.setValues(matrixValues);
        String requestBody = new ObjectMapper().writeValueAsString(matrix);
        MatrixService matrixService = new MatrixService();
        MatrixController controller = new MatrixController(matrixService);

        // Act
        MvcResult result = mockMvc.perform(post("/mirror")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andReturn();

        // Assert
        String responseBody = result.getResponse().getContentAsString();
        Matrix mirroredMatrix = new ObjectMapper().readValue(responseBody, Matrix.class);
        assertEquals(4, mirroredMatrix.getValues().size());
        assertEquals(Arrays.asList(4, 3, 2, 1), mirroredMatrix.getValues().get(0));
        assertEquals(Arrays.asList(8, 7, 6, 5), mirroredMatrix.getValues().get(1));
        assertEquals(Arrays.asList(12, 11, 10, 9), mirroredMatrix.getValues().get(2));
        assertEquals(Arrays.asList(16, 15, 14, 13), mirroredMatrix.getValues().get(3));
    }

}