package com.fernandes.icompras.curso.produtos.hexagonal.adapters.in.controller.mapper;

import com.fernandes.icompras.curso.produtos.hexagonal.adapters.in.controller.request.ProdutoRequest;
import com.fernandes.icompras.curso.produtos.hexagonal.adapters.in.controller.response.ProdutoResponse;
import com.fernandes.icompras.curso.produtos.hexagonal.application.core.domain.Produto;

public interface ProdutoMapper {

    Produto toProduto(ProdutoRequest produtoRequest);

    ProdutoResponse toProdutoResponse(Produto produto);


}
