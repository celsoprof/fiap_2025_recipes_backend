package br.com.fiap.recipes.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity notFoundException(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity noSuchEntityException(NoSuchElementException ex){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity badRequestException(MethodArgumentNotValidException ex){
        System.out.println("--------->ERRO DE MÉTODO");
        List<FieldError> errors = ex.getFieldErrors();
        List<ValidationError> validationErrors = errors.stream().map(ValidationError::new).toList();
        return ResponseEntity.badRequest().body(validationErrors);
    }

    // Record class to mount the message error to client
    public record ValidationError(String field, String message){
        public  ValidationError(FieldError fieldError){
            this(fieldError.getField(), fieldError.getDefaultMessage());
        }
    }

}
