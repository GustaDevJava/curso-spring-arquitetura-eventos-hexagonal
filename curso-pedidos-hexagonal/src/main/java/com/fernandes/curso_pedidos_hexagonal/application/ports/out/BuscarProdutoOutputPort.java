package com.fernandes.curso_pedidos_hexagonal.application.ports.out;

import com.fernandes.curso_pedidos_hexagonal.application.core.domain.Produto;

public interface BuscarProdutoOutputPort {

    Produto obterDadosProduto(Long codigoProduto);
}
