package com.fernandes.icompras.curso.produtos.hexagonal.application.core.domain;

import java.math.BigDecimal;

public class Produto {

    private Long Codigo;

    private String nome;

    private BigDecimal valorUnitario;

    public Produto(){}

    public Produto(Long codigo, String nome, BigDecimal valorUnitario) {
        Codigo = codigo;
        this.nome = nome;
        this.valorUnitario = valorUnitario;
    }

    public Long getCodigo() {
        return Codigo;
    }

    public void setCodigo(Long codigo) {
        Codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
}
