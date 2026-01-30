package com.fernandes.curso_pedidos_hexagonal.application.core.domain;

import java.math.BigDecimal;

public class ItemPedido {

    private Long codigo;

    private Long codigoPedido;

    private Long codigoProduto;

    private Integer quantidade;

    private BigDecimal valorUnitario;

    private String nome;

    public ItemPedido(){}

    public ItemPedido(Long codigoPedido, Long codigo, Long codigoProduto, Integer quantidade, BigDecimal valorUnitario, String nome) {
        this.codigoPedido = codigoPedido;
        this.codigo = codigo;
        this.codigoProduto = codigoProduto;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.nome = nome;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Long getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(Long codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public Long getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(Long codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
