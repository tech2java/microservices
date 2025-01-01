package com.tech2java.accounts.exception;

import com.tech2java.accounts.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerAlreadyExistException.class)
    public ResponseEntity<ErrorResponseDto> handleCustomerAlreadyExistsException(CustomerAlreadyExistException ex, WebRequest webRequest){

        ErrorResponseDto errorResponseDto=new ErrorResponseDto(
          webRequest.getDescription(false),
          HttpStatus.BAD_REQUEST,
          ex.getMessage(),
          LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDto,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(ResourceNotFoundException ex,WebRequest webRequest){
        ErrorResponseDto errorResponseDto=new ErrorResponseDto(
          webRequest.getDescription(false),
          HttpStatus.NOT_FOUND,
          ex.getMessage(),
          LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDto,HttpStatus.NOT_FOUND);
    }

}
