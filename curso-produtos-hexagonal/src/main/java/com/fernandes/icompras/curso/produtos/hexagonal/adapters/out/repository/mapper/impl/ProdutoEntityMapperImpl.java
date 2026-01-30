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
        return produtoEntity;
    }

    @Override
    public Produto toProduto(ProdutoEntity produtoEntity) {
        Produto produto = new Produto();
        produto.setCodigo(produtoEntity.getCodigo());
        produto.setNome(produtoEntity.getNome());
        produto.setValorUnitario(produtoEntity.getValorUnitario());
        return produto;
    }
}
