package com.fernandes.curso_pedidos_hexagonal.application.ports.out;

public interface BuscarProdutoOutputPort {

    void obterDadosProduto(Long codigoProduto);
}
