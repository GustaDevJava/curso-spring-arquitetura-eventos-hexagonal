package com.fernandes.curso_logistica_hexagonal.adapters.in.subscriber.mapper.impl;

import com.fernandes.curso_logistica_hexagonal.adapters.in.subscriber.mapper.AtualizacaoFaturamentoMapper;
import com.fernandes.curso_logistica_hexagonal.adapters.in.subscriber.representation.AtualizacaoFaturamentoRepresentation;
import com.fernandes.curso_logistica_hexagonal.application.core.domain.DadosPedido;
import org.springframework.stereotype.Component;

@Component
public class AtualizacaoFaturamentoMapperImpl implements AtualizacaoFaturamentoMapper {

    @Override
    public DadosPedido toDadosPedido(AtualizacaoFaturamentoRepresentation representation) {
        DadosPedido dadosPedido = new DadosPedido();
        dadosPedido.setCodigo(representation.codigo());
        dadosPedido.setStatus(representation.status());
        dadosPedido.setCodigoRastreio(representation.codigoRastreio());
        dadosPedido.setUrlNotaFiscal(representation.urlNotaFiscal());
        return dadosPedido;
    }
}
