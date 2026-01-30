package com.fernandes.curso_pedidos_hexagonal.application.ports.in;

public interface AtualizarStatusPagamentoInputPort {

    void atualizarStatusPagamento(Long codigoPedido, String chavePagamento, boolean sucesso, String observacoes);
}
