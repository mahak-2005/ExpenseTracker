package Food;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = FoodNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleFoodNotFoundException(FoodNotFoundException ex) {
        ErrorResponse errorResponse= new ErrorResponse(HttpStatus.NOT_FOUND.value(),LocalDateTime.now(),"Food Not Found",exception.getMessage());

        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
        }
        @ExceptionHandler(value = FoodValidationException.class)
    public ResponseEntity<ErrorResponse> handleFoodValidationException(FoodValidationException ex) {
        ErrorResponse errorResponse= new ErrorResponse(HttpStatus.BAD_REQUEST.value(),LocalDateTime.now(),"Bad Request",exception.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
