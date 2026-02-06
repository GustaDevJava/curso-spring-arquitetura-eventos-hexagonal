package com.fernandes.curso_logistica_hexagonal.application.core.domain;

import com.fernandes.curso_logistica_hexagonal.application.core.domain.enums.StatusPedido;

public class DadosPedido {

    private Long codigo;
    private StatusPedido status;
    private String urlNotaFiscal;
    private String codigoRastreio;

    public DadosPedido() {}

    public DadosPedido(Long codigo, StatusPedido status, String urlNotaFiscal, String codigoRastreio) {
        this.codigo = codigo;
        this.status = status;
        this.urlNotaFiscal = urlNotaFiscal;
        this.codigoRastreio = codigoRastreio;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public String getUrlNotaFiscal() {
        return urlNotaFiscal;
    }

    public void setUrlNotaFiscal(String urlNotaFiscal) {
        this.urlNotaFiscal = urlNotaFiscal;
    }

    public String getCodigoRastreio() {
        return codigoRastreio;
    }

    public void setCodigoRastreio(String codigoRastreio) {
        this.codigoRastreio = codigoRastreio;
    }
}
