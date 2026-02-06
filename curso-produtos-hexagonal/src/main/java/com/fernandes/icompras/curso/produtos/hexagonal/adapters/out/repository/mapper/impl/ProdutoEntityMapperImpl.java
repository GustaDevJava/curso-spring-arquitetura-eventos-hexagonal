package com.fernandes.icompras.curso.produtos.hexagonal.adapters.out.repository.mapper.impl;

import com.fernandes.icompras.curso.produtos.hexagonal.adapters.out.repository.entity.ProdutoEntity;
import com.fernandes.icompras.curso.produtos.hexagonal.adapters.out.repository.mapper.ProdutoEntityMapper;
import com.fernandes.icompras.curso.produtos.hexagonal.application.core.domain.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoEntityMapperImpl implements ProdutoEntityMapper {

    @Override
    public ProdutoEntity toProdutoEntity(Produto produto) {
        ProdutoEntity produtoEntity = new ProdutoEntity();
        produtoEntity.setNome(produto.getNome());
        produtoEntity.setValorUnitario(produto.getValorUnitario());
        produtoEntity.setAtivo(produto.isAtivo());
        return produtoEntity;
    }

    @Override
    public ProdutoEntity toProdutoEntityUp(Produto produto) {
        ProdutoEntity produtoEntity = new ProdutoEntity();
        produtoEntity.setCodigo(produto.getCodigo());
        produtoEntity.setNome(produto.getNome());
        produtoEntity.setValorUnitario(produto.getValorUnitario());
        produtoEntity.setAtivo(produto.isAtivo());
        return produtoEntity;
    }

    @Override
    public Produto toProduto(ProdutoEntity produtoEntity) {
        Produto produto = new Produto();
        produto.setCodigo(produtoEntity.getCodigo());
        produto.setNome(produtoEntity.getNome());
        produto.setValorUnitario(produtoEntity.getValorUnitario());
        produto.setAtivo(produtoEntity.isAtivo());
        return produto;
    }
}
