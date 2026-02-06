package com.fernandes.icompras.curso_clientes_hexagonal.application.ports.out;

import com.fernandes.icompras.curso_clientes_hexagonal.application.core.domain.Cliente;

public interface AtualizarClienteOutputPort {

    Cliente atualizar(Cliente cliente);
}
