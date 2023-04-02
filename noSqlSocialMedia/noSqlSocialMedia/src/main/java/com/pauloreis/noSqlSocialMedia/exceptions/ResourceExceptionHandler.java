package com.pauloreis.noSqlSocialMedia.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

  @ExceptionHandler(ObjectNotFoundException.class)
  public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {

    final HttpStatus status = HttpStatus.NOT_FOUND;
    final StandardError error = new StandardError(
        System.currentTimeMillis(),
        status.value(),
        "Not found",
        e.getMessage(),
        request.getRequestURI());

    return ResponseEntity.status(status).body(error);
  }
}
