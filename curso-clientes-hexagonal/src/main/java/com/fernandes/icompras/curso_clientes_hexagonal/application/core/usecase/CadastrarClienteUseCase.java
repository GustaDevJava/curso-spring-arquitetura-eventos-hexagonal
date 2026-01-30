package com.fernandes.icompras.curso_clientes_hexagonal.application.core.usecase;

import com.fernandes.icompras.curso_clientes_hexagonal.application.core.domain.Cliente;
import com.fernandes.icompras.curso_clientes_hexagonal.application.ports.in.CadastrarClienteInputPort;
import com.fernandes.icompras.curso_clientes_hexagonal.application.ports.out.CadastrarClienteOutputPort;

public class CadastrarClienteUseCase implements CadastrarClienteInputPort {

    private final CadastrarClienteOutputPort cadastrarClienteOutputPort;

    public CadastrarClienteUseCase(CadastrarClienteOutputPort cadastrarClienteOutputPort){
        this.cadastrarClienteOutputPort = cadastrarClienteOutputPort;
    }

    @Override
    public Cliente cadastrarCliente(Cliente cliente){
        return cadastrarClienteOutputPort.cadastarCliente(cliente);
    }
}
