package com.fernandes.icompras.curso_clientes_hexagonal.application.ports.out;

import com.fernandes.icompras.curso_clientes_hexagonal.application.core.domain.Cliente;

import java.util.Optional;

public interface BuscarClientePorIdOutputPort {

    Optional<Cliente> buscarPorCodigo(Long codigo);
}
