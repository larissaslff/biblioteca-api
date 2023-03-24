package com.biblioteca.biblioteca.resource.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerException {
 
    @ExceptionHandler(AutorNaoCadastradoException.class)
    public ResponseEntity<ErrorMessage> AutorNaoCadastradoException(AutorNaoCadastradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessage(ex.getMessage(), HttpStatus.NOT_FOUND));
    }
}
