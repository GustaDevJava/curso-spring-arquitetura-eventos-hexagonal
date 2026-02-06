package com.fernandes.curso_pedidos_hexagonal.adapters.out;

import com.fernandes.curso_pedidos_hexagonal.adapters.out.repository.PedidoRepository;
import com.fernandes.curso_pedidos_hexagonal.adapters.out.repository.entity.PedidoEntity;
import com.fernandes.curso_pedidos_hexagonal.adapters.out.repository.mappers.PedidoEntityMapper;
import com.fernandes.curso_pedidos_hexagonal.application.core.domain.Pedido;
import com.fernandes.curso_pedidos_hexagonal.application.ports.out.CriarPedidoOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CriarPedidoAdapter implements CriarPedidoOutputPort {

    private final PedidoRepository repository;

    private final PedidoEntityMapper mapper;

    @Override
    public Pedido criarPedido(Pedido pedido) {
        var pedidoEntity = mapper.toPedidoEntity(pedido);
        pedidoEntity = repository.save(pedidoEntity);
        var pedidoAnalise = mapper.toPedido(pedidoEntity);
        return pedidoAnalise;
    }

}
