package fis.java.topic13.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(BindException.class)
	public ResponseEntity<String> handleAppException(BindException e){
		StringBuilder sb = new StringBuilder();

		e.getBindingResult().getAllErrors().forEach((error) ->{
			String errorMessage = error.getDefaultMessage();
			sb.append(String.format("Error: %s\n", errorMessage));
		});
		
		log.error("Error Message: {}", sb.toString());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
	}
	
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
    	log.error("Error Message: {}", e.getMessage());
        return ResponseEntity.status(500).body(e.getMessage());
    }
}
