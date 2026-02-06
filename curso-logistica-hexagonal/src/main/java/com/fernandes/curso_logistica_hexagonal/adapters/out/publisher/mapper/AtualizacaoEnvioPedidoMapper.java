package com.fernandes.curso_logistica_hexagonal.adapters.out.publisher.mapper;

import com.fernandes.curso_logistica_hexagonal.adapters.out.publisher.representation.AtualizacaoEnvioPedidoRepresentation;
import com.fernandes.curso_logistica_hexagonal.application.core.domain.DadosPedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AtualizacaoEnvioPedidoMapper {

    @Mapping(target = "", source = "urlNotaFiscal", ignore = true)
    AtualizacaoEnvioPedidoRepresentation toAtualizacaoEnvioPedido(DadosPedido dadosPedido);
}
