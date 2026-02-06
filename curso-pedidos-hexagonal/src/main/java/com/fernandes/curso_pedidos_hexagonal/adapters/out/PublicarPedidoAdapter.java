package com.fernandes.curso_pedidos_hexagonal.adapters.out;

import com.fernandes.curso_pedidos_hexagonal.adapters.out.publisher.PagamentoPublisher;
import com.fernandes.curso_pedidos_hexagonal.adapters.out.publisher.mapper.DetalhePedidoMapper;
import com.fernandes.curso_pedidos_hexagonal.application.core.domain.Pedido;
import com.fernandes.curso_pedidos_hexagonal.application.ports.out.PublicarPedidoOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PublicarPedidoAdapter implements PublicarPedidoOutputPort {

    private final PagamentoPublisher publisher;

    private final DetalhePedidoMapper mapper;

    @Override
    public void publicar(Pedido pedido) {
        var detalhePagamento = mapper.toDetalhePedidoRepresentation(pedido);
        publisher.publicar(detalhePagamento);
    }
}
