package com.fernandes.curso_pedidos_hexagonal.application.ports.out;

import com.fernandes.curso_pedidos_hexagonal.application.core.domain.Cliente;

public interface BuscarClienteOutputPort {

    Cliente obterDadosCliente(Long codigoCliente);
}
