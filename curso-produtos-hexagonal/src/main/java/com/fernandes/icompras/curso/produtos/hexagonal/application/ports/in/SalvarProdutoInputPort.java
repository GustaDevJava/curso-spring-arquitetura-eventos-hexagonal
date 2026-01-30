package com.fernandes.icompras.curso.produtos.hexagonal.application.ports.in;

import com.fernandes.icompras.curso.produtos.hexagonal.application.core.domain.Produto;

public interface SalvarProdutoInputPort {

    Produto salvar(Produto produto);
}
