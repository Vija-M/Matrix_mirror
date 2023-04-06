package test.matrix.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class MatrixController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MatrixController.class);


    private MatrixService matrixService;

    @Autowired
    public MatrixController(MatrixService matrixService) {
        this.matrixService = matrixService;
    }

    @PostMapping("/mirror")
    public ResponseEntity<?> mirror(@Validated @RequestBody Matrix matrix, BindingResult result) {
        if (result.hasErrors()) {
            String errorMessage = result.getAllErrors().get(0).getDefaultMessage();
            LOGGER.error("Invalid request: {}", errorMessage);
            return ResponseEntity.badRequest().body(errorMessage);
        }
        LOGGER.info("Received matrix: {}", matrix);
        Matrix mirroredMatrix = matrixService.mirrorMatrix(matrix);
        LOGGER.info("Returning mirrored matrix: {}", mirroredMatrix);
        return ResponseEntity.ok().body(mirroredMatrix);
    }
}




