package com.fernandes.curso_pedidos_hexagonal.application.ports.out;

public interface BuscarClienteOutputPort {

    void obterDadosCliente(Long codigoCliente);
}
