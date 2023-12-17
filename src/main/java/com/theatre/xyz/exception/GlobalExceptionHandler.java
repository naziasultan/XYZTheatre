package com.theatre.xyz.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity handleException(Exception e) {
        return handleExceptionMessage(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity handleException(HttpClientErrorException.NotFound e) {
        return handleExceptionMessage(e, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity handleException(HttpClientErrorException.BadRequest e) {
        return handleExceptionMessage(e, HttpStatus.BAD_REQUEST);

    }

    ResponseEntity handleExceptionMessage(Exception e, HttpStatus status) {
        log.info(e.getMessage(), e);
        return ResponseEntity.status(status)
                .body("An error occurred: " + e.getMessage());
    }

}
