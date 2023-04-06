package test.matrix.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MatrixService {
    public Matrix mirrorMatrix(Matrix matrix) {
        List<List<Integer>> values = new ArrayList<>();
        for ( List<Integer> row : matrix.getValues() ) {
            List<Integer> mirroredRow = new ArrayList<>(row);
            Collections.reverse(mirroredRow);
            values.add(mirroredRow);
        }

        Matrix mirroredMatrix = new Matrix();
        mirroredMatrix.setValues(values);

        return mirroredMatrix;
    }
}


