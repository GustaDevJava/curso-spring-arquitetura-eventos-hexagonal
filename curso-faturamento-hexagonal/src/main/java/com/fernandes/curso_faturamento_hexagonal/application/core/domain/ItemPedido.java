package com.fernandes.curso_faturamento_hexagonal.application.core.domain;

import java.math.BigDecimal;

public class ItemPedido {

    private Long codigo;
    private String descricao;
    private BigDecimal valorUnitario;
    private Integer quantidade;

    public BigDecimal getTotal(){
        return valorUnitario.multiply(BigDecimal.valueOf(quantidade));
    }

    public ItemPedido(){}

    public ItemPedido(Long codigo, String descricao, BigDecimal valorUnitario, Integer quantidade) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}


