package com.fernandes.icompras.curso.produtos.hexagonal.adapters.out;

import com.fernandes.icompras.curso.produtos.hexagonal.adapters.out.repository.ProdutoRepository;
import com.fernandes.icompras.curso.produtos.hexagonal.adapters.out.repository.mapper.ProdutoEntityMapper;
import com.fernandes.icompras.curso.produtos.hexagonal.application.core.domain.Produto;
import com.fernandes.icompras.curso.produtos.hexagonal.application.ports.out.AtualizarProdutoOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AtualizarProdutoAdapter implements AtualizarProdutoOutputPort {

    private final ProdutoRepository repository;

    private final ProdutoEntityMapper mapper;

    @Override
    public Produto atualizar(Produto produto) {
        var produtoEntity = mapper.toProdutoEntityUp(produto);
        produtoEntity = repository.save(produtoEntity);
        return mapper.toProduto(produtoEntity);
    }
}
