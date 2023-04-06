package test.matrix.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MatrixServiceTests {

    @Test
    public void testMatrix() {
        MatrixService matrixService = new MatrixService();

        List<List<Integer>> inputMatrix = new ArrayList<>();
        inputMatrix.add(Arrays.asList(1, 2, 3, 4));
        inputMatrix.add(Arrays.asList(5, 6, 7, 8));
        inputMatrix.add(Arrays.asList(9, 10, 11, 12));
        inputMatrix.add(Arrays.asList(13, 14, 15, 16));

        Matrix input = new Matrix();
        input.setValues(inputMatrix);

        List<List<Integer>> expectedValues = new ArrayList<>();
        expectedValues.add(Arrays.asList(4, 3, 2, 1));
        expectedValues.add(Arrays.asList(8, 7, 6, 5));
        expectedValues.add(Arrays.asList(12, 11, 10, 9));
        expectedValues.add(Arrays.asList(16, 15, 14, 13));

        Matrix expectedOutput = new Matrix();
        expectedOutput.setValues(expectedValues);

        Matrix actualOutput = matrixService.mirrorMatrix(input);

        Assertions.assertEquals(expectedOutput, actualOutput);
    }
}
