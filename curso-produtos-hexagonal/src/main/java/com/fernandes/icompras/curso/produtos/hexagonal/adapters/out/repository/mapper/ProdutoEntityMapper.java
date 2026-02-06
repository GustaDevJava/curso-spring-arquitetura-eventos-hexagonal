package com.fernandes.icompras.curso.produtos.hexagonal.adapters.out.repository.mapper;

import com.fernandes.icompras.curso.produtos.hexagonal.adapters.out.repository.entity.ProdutoEntity;
import com.fernandes.icompras.curso.produtos.hexagonal.application.core.domain.Produto;

public interface ProdutoEntityMapper {

    ProdutoEntity toProdutoEntity(Produto produto);

    ProdutoEntity toProdutoEntityUp(Produto produto);

    Produto toProduto(ProdutoEntity produtoEntity);
}
