package test.matrix.demo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data //generating getters, setters and toString methods
public class Matrix {
    @NotNull //Spring Validation annotation for ensuring that the field is not null
    @Size(min = 4, max = 4, message = "Matrix size should be 4x4") //Spring Validation annotation for ensuring that the field has exactly 4 rows and 4 columns
    private List<List<Integer>> values;

    }

