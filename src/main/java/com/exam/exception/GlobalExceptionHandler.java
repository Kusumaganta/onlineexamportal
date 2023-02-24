package com.exam.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.beans.factory.annotation.Value;
@ControllerAdvice
public class GlobalExceptionHandler {
	 @Value(value="${message1}")
 private String message1;
 @Value(value="${message2}")
 private String message2;
 @Value(value="${message3}")
 private String message3;
 @Value(value="${message4}")
 private String message4;
 @ExceptionHandler(value=UserNotFoundException.class)
 public ResponseEntity userNotFound(UserNotFoundException ex) {
 return new ResponseEntity(message1,HttpStatus.CONFLICT);
}
 @ExceptionHandler(value=UserAlreadyExistsException.class)
 public ResponseEntity userAlreadyExists(UserAlreadyExistsException ex) {
 return new ResponseEntity(message2,HttpStatus.CONFLICT);
}
 @ExceptionHandler(value=CategoryNotFoundException.class)
 public ResponseEntity categoryNotFound(CategoryNotFoundException ex) {
 return new ResponseEntity(message3,HttpStatus.CONFLICT);
}
 @ExceptionHandler(value=CategoryAlreadyExistsException.class)
 public ResponseEntity categoryAlreadyExists(CategoryAlreadyExistsException ex) {
 return new ResponseEntity(message4,HttpStatus.CONFLICT);
}
}