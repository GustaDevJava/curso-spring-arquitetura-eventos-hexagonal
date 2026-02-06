package com.fernandes.curso_pedidos_hexagonal.application.ports.out;

import com.fernandes.curso_pedidos_hexagonal.application.core.domain.ItemPedido;
import com.fernandes.curso_pedidos_hexagonal.application.core.domain.Pedido;

import java.util.List;

public interface BuscarItensPedidoOutputPort {

    List<ItemPedido> buscarItensPedido(Pedido pedido);
}
