package com.fernandes.curso_pedidos_hexagonal.application.ports.out;

import com.fernandes.curso_pedidos_hexagonal.application.core.domain.Pedido;

public interface CriarPedidoOutputPort {

    Pedido criarPedido(Pedido pedido);
}
