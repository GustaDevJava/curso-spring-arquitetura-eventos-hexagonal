package com.fernandes.curso_faturamento_hexagonal.adapters.out.jasper.mapper;

import com.fernandes.curso_faturamento_hexagonal.adapters.out.jasper.representation.PedidoNotaRepresentation;
import com.fernandes.curso_faturamento_hexagonal.application.core.domain.Pedido;

public interface PedidoNotaMapper {

    PedidoNotaRepresentation toPedidoNota(Pedido pedido);
}
