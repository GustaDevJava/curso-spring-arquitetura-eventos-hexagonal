package com.fernandes.curso_logistica_hexagonal.adapters.in.subscriber.mapper;

import com.fernandes.curso_logistica_hexagonal.adapters.in.subscriber.representation.AtualizacaoFaturamentoRepresentation;
import com.fernandes.curso_logistica_hexagonal.application.core.domain.DadosPedido;

public interface AtualizacaoFaturamentoMapper {

    DadosPedido toDadosPedido(AtualizacaoFaturamentoRepresentation representation);
}
