package com.fernandes.icompras.curso.produtos.hexagonal.application.core.usecase;

import com.fernandes.icompras.curso.produtos.hexagonal.application.core.exception.ProdutoNaoEncontradoException;
import com.fernandes.icompras.curso.produtos.hexagonal.application.ports.in.ExclusaoLogicaProdutoInputPort;
import com.fernandes.icompras.curso.produtos.hexagonal.application.ports.out.AtualizarProdutoOutputPort;
import com.fernandes.icompras.curso.produtos.hexagonal.application.ports.out.ConsultaProdutoPorIdOutputPort;

public class ExclusaoLogicaProdutoUseCase implements ExclusaoLogicaProdutoInputPort {

    private final ConsultaProdutoPorIdOutputPort consultaProdutoPorIdOutputPort;

    private final AtualizarProdutoOutputPort atualizarProdutoOutputPort;

    public ExclusaoLogicaProdutoUseCase(ConsultaProdutoPorIdOutputPort consultaProdutoPorIdOutputPort, AtualizarProdutoOutputPort atualizarProdutoOutputPort) {
        this.consultaProdutoPorIdOutputPort = consultaProdutoPorIdOutputPort;
        this.atualizarProdutoOutputPort = atualizarProdutoOutputPort;
    }


    @Override
    public void deletar(Long codigo) {
        var produtoOptional = consultaProdutoPorIdOutputPort.buscarPorCodigo(codigo);

        if(produtoOptional.isEmpty()){
            throw new ProdutoNaoEncontradoException("Produto não encontrado!");
        }

        var pedido = produtoOptional.get();

        pedido.setAtivo(false);

        atualizarProdutoOutputPort.atualizar(pedido);

    }
}
