package com.fernandes.icompras.curso.produtos.hexagonal.application.core.usecase;

import com.fernandes.icompras.curso.produtos.hexagonal.application.core.domain.Produto;
import com.fernandes.icompras.curso.produtos.hexagonal.application.ports.in.SalvarProdutoInputPort;
import com.fernandes.icompras.curso.produtos.hexagonal.application.ports.out.SalvarProdutoOutputPort;

public class SalvarProdutoUseCase implements SalvarProdutoInputPort {

    private final SalvarProdutoOutputPort salvarProdutoOutputPort;

    public SalvarProdutoUseCase(SalvarProdutoOutputPort salvarProdutoOutputPort){
        this.salvarProdutoOutputPort = salvarProdutoOutputPort;
    }

    @Override
    public Produto salvar(Produto produto){
        return salvarProdutoOutputPort.salvar(produto);
    }
}
