package com.fernandes.icompras.curso.produtos.hexagonal.application.ports.out;

import com.fernandes.icompras.curso.produtos.hexagonal.application.core.domain.Produto;

public interface AtualizarProdutoOutputPort {

    Produto atualizar(Produto produto);
}
