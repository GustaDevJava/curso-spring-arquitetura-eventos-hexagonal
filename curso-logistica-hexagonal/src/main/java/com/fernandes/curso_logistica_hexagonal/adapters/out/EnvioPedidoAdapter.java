package com.fernandes.curso_logistica_hexagonal.adapters.out;

import com.fernandes.curso_logistica_hexagonal.adapters.out.publisher.EnvioPedidoPublisher;
import com.fernandes.curso_logistica_hexagonal.adapters.out.publisher.mapper.AtualizacaoEnvioPedidoMapper;
import com.fernandes.curso_logistica_hexagonal.application.core.domain.DadosPedido;
import com.fernandes.curso_logistica_hexagonal.application.ports.out.EnvioPedidoOutputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EnvioPedidoAdapter implements EnvioPedidoOutputPort {

    private final EnvioPedidoPublisher publisher;

    private final AtualizacaoEnvioPedidoMapper mapper;

    @Override
    public void enviar(DadosPedido dadosPedido) {
        var atualizacaoEnvioPedido = mapper.toAtualizacaoEnvioPedido(dadosPedido);
        publisher.enviarPedido(atualizacaoEnvioPedido);
    }
}