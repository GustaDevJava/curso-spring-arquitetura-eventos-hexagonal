package com.fernandes.curso_pedidos_hexagonal.adapters.out;

import com.fernandes.curso_pedidos_hexagonal.adapters.out.repository.PedidoRepository;
import com.fernandes.curso_pedidos_hexagonal.adapters.out.repository.mappers.PedidoEntityMapper;
import com.fernandes.curso_pedidos_hexagonal.application.core.domain.Pedido;
import com.fernandes.curso_pedidos_hexagonal.application.ports.out.AtualizarPedidoOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AtualizarPedidoAdapter implements AtualizarPedidoOutputPort {

    private final PedidoRepository repository;

    private final PedidoEntityMapper mapper;

    @Override
    public void atualizarPedido(Pedido pedido) {
        var pedidoEntity = mapper.toPedidoEntity(pedido);
        repository.save(pedidoEntity);
    }
}
