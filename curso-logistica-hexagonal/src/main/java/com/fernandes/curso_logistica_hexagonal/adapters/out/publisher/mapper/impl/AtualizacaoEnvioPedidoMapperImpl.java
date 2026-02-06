package com.fernandes.curso_logistica_hexagonal.adapters.out.publisher.mapper.impl;

import com.fernandes.curso_logistica_hexagonal.adapters.out.publisher.mapper.AtualizacaoEnvioPedidoMapper;
import com.fernandes.curso_logistica_hexagonal.adapters.out.publisher.representation.AtualizacaoEnvioPedidoRepresentation;
import com.fernandes.curso_logistica_hexagonal.application.core.domain.DadosPedido;
import org.springframework.stereotype.Component;

@Component
public class AtualizacaoEnvioPedidoMapperImpl implements AtualizacaoEnvioPedidoMapper {

    @Override
    public AtualizacaoEnvioPedidoRepresentation toAtualizacaoEnvioPedido(DadosPedido dadosPedido) {

        return new AtualizacaoEnvioPedidoRepresentation(dadosPedido.getCodigo(), dadosPedido.getStatus(), dadosPedido.getCodigoRastreio());
    }
}
