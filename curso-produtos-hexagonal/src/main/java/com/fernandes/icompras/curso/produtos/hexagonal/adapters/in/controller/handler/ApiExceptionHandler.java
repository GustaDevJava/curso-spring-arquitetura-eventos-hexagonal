package com.fernandes.icompras.curso.produtos.hexagonal.adapters.in.controller.handler;

import com.fernandes.icompras.curso.produtos.hexagonal.application.core.exception.ProdutoNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ProdutoNaoEncontradoException.class)
    public ResponseEntity<StandardError> produtoNaoEncontradoException(ProdutoNaoEncontradoException e) {
        StandardError error = new StandardError();
        error.setCodigo(HttpStatus.NOT_FOUND.value());
        error.setMensagem(e.getMessage());
        return ResponseEntity.status(error.getCodigo()).body(error);
    }
}