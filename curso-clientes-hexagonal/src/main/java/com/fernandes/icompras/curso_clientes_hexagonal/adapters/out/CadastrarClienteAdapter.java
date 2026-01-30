package com.fernandes.icompras.curso_clientes_hexagonal.adapters.out;

import com.fernandes.icompras.curso_clientes_hexagonal.adapters.out.repository.ClienteRepository;
import com.fernandes.icompras.curso_clientes_hexagonal.adapters.out.repository.mapper.ClienteEntityMapper;
import com.fernandes.icompras.curso_clientes_hexagonal.application.core.domain.Cliente;
import com.fernandes.icompras.curso_clientes_hexagonal.application.ports.out.CadastrarClienteOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CadastrarClienteAdapter implements CadastrarClienteOutputPort {

    private final ClienteRepository repository;

    private final ClienteEntityMapper mapper;

    @Override
    public Cliente cadastarCliente(Cliente cliente) {
        var clienteEntity = mapper.toClienteEntity(cliente);
        repository.save(clienteEntity);
        return mapper.toCliente(clienteEntity);
    }
}
