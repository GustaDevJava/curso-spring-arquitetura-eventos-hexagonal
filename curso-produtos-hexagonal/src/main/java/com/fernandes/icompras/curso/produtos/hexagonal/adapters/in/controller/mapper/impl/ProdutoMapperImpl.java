package com.fernandes.icompras.curso.produtos.hexagonal.adapters.in.controller.mapper.impl;

import com.fernandes.icompras.curso.produtos.hexagonal.adapters.in.controller.mapper.ProdutoMapper;
import com.fernandes.icompras.curso.produtos.hexagonal.adapters.in.controller.request.ProdutoRequest;
import com.fernandes.icompras.curso.produtos.hexagonal.adapters.in.controller.response.ProdutoResponse;
import com.fernandes.icompras.curso.produtos.hexagonal.application.core.domain.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapperImpl implements ProdutoMapper {

    @Override
    public Produto toProduto(ProdutoRequest produtoRequest) {
        Produto produto = new Produto();
        produto.setNome(produtoRequest.getNome());
        produto.setValorUnitario(produtoRequest.getValorUnitario());
        return produto;
    }

    @Override
    public ProdutoResponse toProdutoResponse(Produto produto) {
        ProdutoResponse produtoResponse = new ProdutoResponse();
        produtoResponse.setCodigo(produto.getCodigo());
        produtoResponse.setNome(produto.getNome());
        produtoResponse.setValorUnitario(produto.getValorUnitario());
        produtoResponse.setAtivo(produto.isAtivo());
        return produtoResponse;
    }
}
