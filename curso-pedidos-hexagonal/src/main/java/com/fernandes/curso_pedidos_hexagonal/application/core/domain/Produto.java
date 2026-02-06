package com.fernandes.curso_pedidos_hexagonal.application.core.domain;

public class Produto {

    private String nome;
    private boolean ativo;

    public Produto() {
    }

    public Produto(String nome, boolean ativo) {

        this.nome = nome;
        this.ativo = ativo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
