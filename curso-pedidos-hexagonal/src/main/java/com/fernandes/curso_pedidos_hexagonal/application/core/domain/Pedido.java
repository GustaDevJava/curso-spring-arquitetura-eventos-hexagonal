package com.fernandes.curso_pedidos_hexagonal.application.core.domain;

import com.fernandes.curso_pedidos_hexagonal.application.core.domain.enums.StatusPedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Pedido {

    private Long codigo;

    private Long codigoCliente;

    private LocalDateTime dataPedido;

    private BigDecimal total;

    private String chavePagamento;

    private String observacoes;

    private StatusPedido status;

    private String codigoRastreio;

    private DadosPagamento dadosPagamento;

    private List<ItemPedido> itens;

    private Cliente dadosCliente;

    public Pedido(){}

    public Pedido(Long codigo, Long codigoCliente, LocalDateTime dataPedido, BigDecimal total, String chavePagamento, String observacoes, StatusPedido status, List<ItemPedido> itens, DadosPagamento dadosPagamento, String codigoRastreio, Cliente dadosCliente) {
        this.codigo = codigo;
        this.codigoCliente = codigoCliente;
        this.dataPedido = dataPedido;
        this.total = total;
        this.chavePagamento = chavePagamento;
        this.observacoes = observacoes;
        this.status = status;
        this.itens = itens;
        this.dadosPagamento = dadosPagamento;
        this.codigoRastreio = codigoRastreio;
        this.dadosCliente = dadosCliente;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Long getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Long codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getChavePagamento() {
        return chavePagamento;
    }

    public void setChavePagamento(String chavePagamento) {
        this.chavePagamento = chavePagamento;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getCodigoRastreio() {
        return codigoRastreio;
    }

    public void setCodigoRastreio(String codigoRastreio) {
        this.codigoRastreio = codigoRastreio;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public DadosPagamento getDadosPagamento() {
        return dadosPagamento;
    }

    public void setDadosPagamento(DadosPagamento dadosPagamento) {
        this.dadosPagamento = dadosPagamento;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public Cliente getDadosCliente() {
        return dadosCliente;
    }

    public void setDadosCliente(Cliente dadosCliente) {
        this.dadosCliente = dadosCliente;
    }
}
