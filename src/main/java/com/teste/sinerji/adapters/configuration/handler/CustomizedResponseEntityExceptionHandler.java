package com.teste.sinerji.adapters.configuration.handler;

import com.teste.sinerji.core.domain.exception.BusinessException;
import com.teste.sinerji.core.domain.exception.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllException(Exception ex, WebRequest webRequest){
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(),ex.getMessage(),webRequest.getDescription(true));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(BusinessException.class)
    public final ResponseEntity<ExceptionResponse> handleBusinessException(Exception ex, WebRequest webRequest){
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(),ex.getMessage(),webRequest.getDescription(true));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);


    }
}
