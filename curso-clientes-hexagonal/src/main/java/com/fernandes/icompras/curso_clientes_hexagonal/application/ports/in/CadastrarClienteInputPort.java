package com.fernandes.icompras.curso_clientes_hexagonal.application.ports.in;

import com.fernandes.icompras.curso_clientes_hexagonal.application.core.domain.Cliente;

public interface CadastrarClienteInputPort {

    Cliente cadastrarCliente(Cliente cliente);
}
