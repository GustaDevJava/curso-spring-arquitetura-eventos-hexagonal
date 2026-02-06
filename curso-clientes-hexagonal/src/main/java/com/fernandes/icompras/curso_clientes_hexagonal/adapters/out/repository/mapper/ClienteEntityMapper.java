package com.fernandes.icompras.curso_clientes_hexagonal.adapters.out.repository.mapper;

import com.fernandes.icompras.curso_clientes_hexagonal.adapters.out.repository.entity.ClienteEntity;
import com.fernandes.icompras.curso_clientes_hexagonal.application.core.domain.Cliente;

public interface ClienteEntityMapper {

    ClienteEntity toClienteEntity(Cliente cliente);

    ClienteEntity toClienteEntityUp(Cliente cliente);

    Cliente toCliente(ClienteEntity clienteEntity);
}
