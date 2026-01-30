package com.fernandes.icompras.curso_clientes_hexagonal.application.core.exception;


public class ClienteNaoEncontradoException extends RuntimeException{

        public ClienteNaoEncontradoException(String msg){
            super(msg);
        }
}
