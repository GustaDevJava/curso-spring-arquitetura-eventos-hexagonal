package com.fernandes.curso_pedidos_hexagonal.adapters.out;

import com.fernandes.curso_pedidos_hexagonal.application.core.domain.Pedido;
import com.fernandes.curso_pedidos_hexagonal.application.ports.out.CriarPedidoOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CriarPedidoMongoAdapater implements CriarPedidoOutputPort {


    @Override
    public Pedido criarPedido(Pedido pedido) {
        return null;
    }
}
