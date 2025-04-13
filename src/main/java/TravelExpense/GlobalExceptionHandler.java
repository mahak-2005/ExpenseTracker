package TravelExpense;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = TravelNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleTravelNotFoundException(TravelNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), LocalDateTime.now(),"Travel Not Found",exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);


    }
    @ExceptionHandler(value = TravelNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleTravelValidationException(TravelValidationException ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), LocalDateTime.now(), "Bad Request", exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
