package com.fernandes.curso_pedidos_hexagonal.application.ports.in;

import com.fernandes.curso_pedidos_hexagonal.application.core.domain.enums.TipoPagamento;

public interface AdicionarNovoPagamentoInuptPort {

    void adicionarNovoPagamento(Long codigoPedido, String dadosCartao, TipoPagamento tipo);
}
