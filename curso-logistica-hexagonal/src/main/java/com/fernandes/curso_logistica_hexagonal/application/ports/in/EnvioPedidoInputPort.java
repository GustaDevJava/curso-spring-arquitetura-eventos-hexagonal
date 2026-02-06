package com.fernandes.curso_logistica_hexagonal.application.ports.in;

public interface EnvioPedidoInputPort {

    void enviar(Long codigoPedido, String urlNotaFiscal);
}
