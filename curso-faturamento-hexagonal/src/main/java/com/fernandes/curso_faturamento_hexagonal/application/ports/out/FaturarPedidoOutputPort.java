package com.fernandes.curso_faturamento_hexagonal.application.ports.out;

import com.fernandes.curso_faturamento_hexagonal.application.core.domain.Pedido;

public interface FaturarPedidoOutputPort {

    void publicar(Pedido pedido, String urlNotaFiscal);
}
