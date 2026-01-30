package com.fernandes.curso_pedidos_hexagonal.adapters.in.controller.handler;

import com.fernandes.curso_pedidos_hexagonal.application.core.exception.PedidoNaoEncontradoException;
import com.fernandes.curso_pedidos_hexagonal.application.core.exception.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<StandardError> validationException(ValidationException e) {
        StandardError error = new StandardError();
        error.setCodigo(HttpStatus.BAD_REQUEST.value());
        error.setMensagem(e.getMessage());
        return ResponseEntity.status(error.getCodigo()).body(error);
    }

    @ExceptionHandler(PedidoNaoEncontradoException.class)
    public ResponseEntity<StandardError> pedidoNaoEncontradoException(PedidoNaoEncontradoException e){
        StandardError error = new StandardError();
        error.setCodigo(e.getStatus());
        error.setMensagem(e.getMessage());
        return ResponseEntity.status(error.getCodigo()).body(error);
    }
}
