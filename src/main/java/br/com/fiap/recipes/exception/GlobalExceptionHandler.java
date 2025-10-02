package br.com.fiap.recipes.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity notFoundException(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(NoSuchFieldException.class)
    public ResponseEntity noSuchEntityException(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity badRequestException(MethodArgumentNotValidException ex){
        System.out.println("--------->ERRO DE MÉTODO");
        List<FieldError> errors = ex.getFieldErrors();

        List<ValidationError> validationErrors = errors.stream().map(ValidationError::new).toList();

        return ResponseEntity.badRequest().body(validationErrors);
    }

    public record ValidationError(String field, String message){
        public  ValidationError(FieldError fieldError){
            this(fieldError.getField(), fieldError.getDefaultMessage());
        }
    }

//    @ExceptionHandler(RecipeNotFountException.class)
//    public ResponseEntity<Object> handleException(RecipeNotFountException exception) {
//        Map<String,Object> body = new HashMap<>();
//        body.put("timestamp", LocalDate.now());
//        body.put("status", HttpStatus.NOT_FOUND.value());
//        body.put("error", "Recipe Not Found");
//        body.put("message", exception.getMessage());
//
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
//    }
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Object> handleException(MethodArgumentNotValidException exception) {
//        Map<String,Object> body = new HashMap<>();
//        body.put("timestamp", LocalDate.now());
//        body.put("status", HttpStatus.BAD_REQUEST.value());
//        body.put("error", "Bad Request");
//
//        List<String> errors = exception.getBindingResult()
//                .getFieldErrors()
//                .stream()
//                .map(fieldError -> fieldError.getField() + ":" + fieldError.getDefaultMessage())
//                .collect(Collectors.toList());
//
//        body.put("details", errors);
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
//    }
//
//    @ExceptionHandler(ConstraintViolationException.class)
//    public ResponseEntity<Object> handleException(ConstraintViolationException exception) {
//        Map<String,Object> body = new HashMap<>();
//        body.put("timestamp", LocalDate.now());
//        body.put("status", HttpStatus.BAD_REQUEST.value());
//        body.put("error", "Bad Request");
//
//        List<String> errors = exception
//                .getConstraintViolations()
//                .stream()
//                .map(a -> "erro" + ":" + a.getMessage()).collect(Collectors.toList());
//
//        body.put("details", errors);
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
//    }

}
