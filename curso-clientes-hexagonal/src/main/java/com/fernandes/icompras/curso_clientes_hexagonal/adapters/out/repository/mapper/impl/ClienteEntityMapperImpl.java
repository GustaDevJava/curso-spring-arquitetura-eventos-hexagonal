package com.fernandes.icompras.curso_clientes_hexagonal.adapters.out.repository.mapper.impl;

import com.fernandes.icompras.curso_clientes_hexagonal.adapters.out.repository.entity.ClienteEntity;
import com.fernandes.icompras.curso_clientes_hexagonal.adapters.out.repository.mapper.ClienteEntityMapper;
import com.fernandes.icompras.curso_clientes_hexagonal.application.core.domain.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteEntityMapperImpl implements ClienteEntityMapper {


    @Override
    public ClienteEntity toClienteEntity(Cliente cliente) {
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setNome(cliente.getNome());
        clienteEntity.setCpf(cliente.getCpf());
        clienteEntity.setLogradouro(cliente.getLogradouro());
        clienteEntity.setNumero(cliente.getNumero());
        clienteEntity.setBairro(cliente.getBairro());
        clienteEntity.setEmail(cliente.getEmail());
        clienteEntity.setTelefone(cliente.getTelefone());
        clienteEntity.setAtivo(cliente.isAtivo());

        return clienteEntity;
    }

    @Override
    public ClienteEntity toClienteEntityUp(Cliente cliente) {
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setCodigo(cliente.getCodigo());
        clienteEntity.setNome(cliente.getNome());
        clienteEntity.setCpf(cliente.getCpf());
        clienteEntity.setLogradouro(cliente.getLogradouro());
        clienteEntity.setNumero(cliente.getNumero());
        clienteEntity.setBairro(cliente.getBairro());
        clienteEntity.setEmail(cliente.getEmail());
        clienteEntity.setTelefone(cliente.getTelefone());
        clienteEntity.setAtivo(cliente.isAtivo());

        return clienteEntity;
    }

    @Override
    public Cliente toCliente(ClienteEntity clienteEntity) {
        Cliente cliente = new Cliente();
        cliente.setCodigo(clienteEntity.getCodigo());
        cliente.setNome(clienteEntity.getNome());
        cliente.setCpf(clienteEntity.getCpf());
        cliente.setLogradouro(clienteEntity.getLogradouro());
        cliente.setNumero(clienteEntity.getNumero());
        cliente.setBairro(clienteEntity.getBairro());
        cliente.setEmail(clienteEntity.getEmail());
        cliente.setTelefone(clienteEntity.getTelefone());
        cliente.setAtivo(clienteEntity.isAtivo());

        return cliente;
    }
}
