package com.tobeto.rentACar.core.utilities.exceptions;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@Configuration
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleValidationError(MethodArgumentNotValidException exception){
        BindingResult bindingResult = exception.getBindingResult();

        //Retrieve field errors
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();

        //Build a message with details of validation errors
        StringBuilder errorMessage = new StringBuilder("Validation Error! ");

        for (FieldError fieldError : fieldErrors) {
            errorMessage.append("Field '")
                    .append(fieldError.getField())
                    .append("': ")
                    .append(fieldError.getDefaultMessage())
                    .append("; ");
        }
        return errorMessage.toString();
    }

    @ExceptionHandler({RuntimeException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleRuntimeException(RuntimeException exception){
        return exception.getMessage();
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleValidationError(Exception exception){
        return "Unknown Error!";
    }
}
