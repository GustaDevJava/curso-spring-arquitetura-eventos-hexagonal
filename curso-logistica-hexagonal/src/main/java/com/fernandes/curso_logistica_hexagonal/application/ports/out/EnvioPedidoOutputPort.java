package com.fernandes.curso_logistica_hexagonal.application.ports.out;

import com.fernandes.curso_logistica_hexagonal.application.core.domain.DadosPedido;

public interface EnvioPedidoOutputPort {

    void enviar(DadosPedido dadosPedido);
}
