package com.fernandes.icompras.curso_clientes_hexagonal.application.core.domain;

public class Cliente {

    private Long codigo;
    private String nome;
    private String cpf;
    private String logradouro;
    private String numero;
    private String bairro;
    private String email;
    private String telefone;

    public Cliente(){}

    public Cliente(Long codigo, String nome, String logradouro, String cpf, String numero, String email, String bairro, String telefone) {
        this.codigo = codigo;
        this.nome = nome;
        this.logradouro = logradouro;
        this.cpf = cpf;
        this.numero = numero;
        this.email = email;
        this.bairro = bairro;
        this.telefone = telefone;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
