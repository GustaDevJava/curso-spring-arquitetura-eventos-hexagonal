package com.fernandes.curso_faturamento_hexagonal.application.core.domain;

import java.math.BigDecimal;
import java.util.List;

public class Pedido {

    private Long codigo;
    private Cliente cliente;
    private String data;
    private BigDecimal total;
    private List<ItemPedido> itens;

    public Pedido(){}

    public Pedido(Long codigo, Cliente cliente, String data, BigDecimal total, List<ItemPedido> itens) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.data = data;
        this.total = total;
        this.itens = itens;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }
}
