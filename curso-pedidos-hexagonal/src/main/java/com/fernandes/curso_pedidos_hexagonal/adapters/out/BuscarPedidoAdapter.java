package com.fernandes.curso_pedidos_hexagonal.adapters.out;

import com.fernandes.curso_pedidos_hexagonal.adapters.out.repository.PedidoRepository;
import com.fernandes.curso_pedidos_hexagonal.adapters.out.repository.mappers.PedidoEntityMapper;
import com.fernandes.curso_pedidos_hexagonal.application.core.domain.Pedido;
import com.fernandes.curso_pedidos_hexagonal.application.ports.out.BuscarPedidoPorCodigoEChaveOutputPort;
import com.fernandes.curso_pedidos_hexagonal.application.ports.out.BuscarPedidoPorCodigoOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BuscarPedidoAdapter implements BuscarPedidoPorCodigoEChaveOutputPort, BuscarPedidoPorCodigoOutputPort {

    private final PedidoRepository repository;
    private final PedidoEntityMapper mapper;

    @Override
    public Optional<Pedido> buscarPorCodigoEChavePagamento(Long codigo, String chavePagamento) {
        var pedidoEntity = repository.findByCodigoAndChavePagamento(codigo, chavePagamento);
        return pedidoEntity.map(mapper::toPedido);
    }

    @Override
    public Optional<Pedido> buscarPorCodigo(Long codigo) {
        var pedidoEntity = repository.findById(codigo);
        return pedidoEntity.map(mapper::toPedido);
    }
}
