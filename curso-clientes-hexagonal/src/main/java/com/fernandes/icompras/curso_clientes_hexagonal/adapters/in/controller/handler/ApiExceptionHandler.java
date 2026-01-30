package com.fernandes.icompras.curso_clientes_hexagonal.adapters.in.controller.handler;

import com.fernandes.icompras.curso_clientes_hexagonal.application.core.exception.ClienteNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ClienteNaoEncontradoException.class)
    public ResponseEntity<StandardError> clienteNaoEncontradoException(ClienteNaoEncontradoException e){
        StandardError error = new StandardError();
        error.setCodigo(HttpStatus.NOT_FOUND.value());
        error.setMensagem(e.getMessage());
        return ResponseEntity.status(error.getCodigo()).body(error);
    }

}
