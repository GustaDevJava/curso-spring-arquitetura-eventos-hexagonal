package com.fernandes.curso_pedidos_hexagonal.application.ports.out;

import com.fernandes.curso_pedidos_hexagonal.application.core.domain.Pedido;

import java.util.Optional;

public interface BuscarPedidoPorCodigoOutputPort {

    Optional<Pedido> buscarPorCodigo(Long codigo);
}
