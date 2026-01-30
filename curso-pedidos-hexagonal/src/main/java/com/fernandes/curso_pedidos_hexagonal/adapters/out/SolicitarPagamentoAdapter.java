package com.fernandes.curso_pedidos_hexagonal.adapters.out;

import com.fernandes.curso_pedidos_hexagonal.adapters.out.client.ServicoBancarioClient;
import com.fernandes.curso_pedidos_hexagonal.adapters.out.client.mapper.PedidoClientMapper;
import com.fernandes.curso_pedidos_hexagonal.application.core.domain.Pedido;
import com.fernandes.curso_pedidos_hexagonal.application.ports.out.SolicitarPagamentoOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SolicitarPagamentoAdapter implements SolicitarPagamentoOutputPort {

    private final ServicoBancarioClient client;

    private final PedidoClientMapper mapper;

    @Override
    public String solicitarPagamento(Pedido pedido) {
        var pedidoClient = mapper.toPedidoClient(pedido);
        return client.solicitarPagamento(pedidoClient);
    }
}
