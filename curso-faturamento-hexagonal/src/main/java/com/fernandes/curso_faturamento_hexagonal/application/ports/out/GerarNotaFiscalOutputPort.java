package com.fernandes.curso_faturamento_hexagonal.application.ports.out;

import com.fernandes.curso_faturamento_hexagonal.application.core.domain.Pedido;

public interface GerarNotaFiscalOutputPort {

    String gerarNotaFiscal(Pedido pedido);
}
