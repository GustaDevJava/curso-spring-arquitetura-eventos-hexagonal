package com.fernandes.curso_pedidos_hexagonal.application.core.domain;

import com.fernandes.curso_pedidos_hexagonal.application.core.domain.enums.TipoPagamento;

public class DadosPagamento {

    private String dados;
    private TipoPagamento tipoPagamento;

    public DadosPagamento(){}

    public DadosPagamento(String dados, TipoPagamento tipoPagamento) {
        this.dados = dados;
        this.tipoPagamento = tipoPagamento;
    }

    public String getDados() {
        return dados;
    }

    public void setDados(String dados) {
        this.dados = dados;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
}
