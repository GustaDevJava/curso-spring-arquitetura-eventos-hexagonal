package com.fernandes.icompras.curso.produtos.hexagonal.application.core.usecase;

import com.fernandes.icompras.curso.produtos.hexagonal.application.core.domain.Produto;
import com.fernandes.icompras.curso.produtos.hexagonal.application.core.exception.ProdutoNaoEncontradoException;
import com.fernandes.icompras.curso.produtos.hexagonal.application.ports.in.ConsultaProdutoPorIdInputPort;
import com.fernandes.icompras.curso.produtos.hexagonal.application.ports.out.ConsultaProdutoPorIdOutputPort;

public class ConsultaProdutoPorIdUseCase implements ConsultaProdutoPorIdInputPort {

    private final ConsultaProdutoPorIdOutputPort consultaProdutoPorIdOutputPort;

    public ConsultaProdutoPorIdUseCase(ConsultaProdutoPorIdOutputPort consultaProdutoPorIdOutputPort){
        this.consultaProdutoPorIdOutputPort = consultaProdutoPorIdOutputPort;
    }

    @Override
    public Produto buscarPorCodigo(Long codigo){
        var produto = consultaProdutoPorIdOutputPort.buscarPorCodigo(codigo);
        return produto.orElseThrow(() -> new ProdutoNaoEncontradoException("Erro ao buscar produto"));
    }
}
