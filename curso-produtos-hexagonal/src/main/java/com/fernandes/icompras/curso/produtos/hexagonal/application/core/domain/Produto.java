package com.fernandes.icompras.curso.produtos.hexagonal.application.core.domain;

import java.math.BigDecimal;

public class Produto {

    private Long codigo;

    private String nome;

    private BigDecimal valorUnitario;

    private boolean ativo = true;

    public Produto(){}

    public Produto(Long codigo, String nome, BigDecimal valorUnitario, boolean ativo) {
        this.codigo = codigo;
        this.nome = nome;
        this.valorUnitario = valorUnitario;
        this.ativo = ativo;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
