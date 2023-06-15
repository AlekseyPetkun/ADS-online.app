package pro.sky.adsonlineapp.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pro.sky.adsonlineapp.exceptions.NotFoundEntityException;
import pro.sky.adsonlineapp.exceptions.ValidationException;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler
    public ResponseEntity handlerValidationException(ValidationException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    public ResponseEntity handlerNotFoundEntityException(NotFoundEntityException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }




}
