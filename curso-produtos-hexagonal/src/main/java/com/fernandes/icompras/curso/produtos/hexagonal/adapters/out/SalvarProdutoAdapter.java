package com.fernandes.icompras.curso.produtos.hexagonal.adapters.out;

import com.fernandes.icompras.curso.produtos.hexagonal.adapters.out.repository.ProdutoRepository;
import com.fernandes.icompras.curso.produtos.hexagonal.adapters.out.repository.mapper.ProdutoEntityMapper;
import com.fernandes.icompras.curso.produtos.hexagonal.application.core.domain.Produto;
import com.fernandes.icompras.curso.produtos.hexagonal.application.ports.out.SalvarProdutoOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SalvarProdutoAdapter implements SalvarProdutoOutputPort {

    private final ProdutoRepository repository;

    private final ProdutoEntityMapper mapper;


    @Override
    public Produto salvar(Produto produto) {
        var produtoEntity = mapper.toProdutoEntity(produto);
        produtoEntity = repository.save(produtoEntity);
        produto = mapper.toProduto(produtoEntity);
        return produto;
    }
}
