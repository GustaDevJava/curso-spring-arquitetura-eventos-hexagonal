package com.fernandes.curso_pedidos_hexagonal.application.core.exception;

public class PedidoNaoEncontradoException extends RuntimeException{

    private Integer status;

    public PedidoNaoEncontradoException(String msg, Integer status){
        super(msg);
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}
