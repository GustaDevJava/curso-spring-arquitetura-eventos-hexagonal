package com.fernandes.icompras.curso.produtos.hexagonal.application.core.exception;

public class ProdutoNaoEncontradoException extends RuntimeException{

    public ProdutoNaoEncontradoException(String msg){
        super(msg);
    }
}
