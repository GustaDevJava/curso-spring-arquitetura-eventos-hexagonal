package com.fernandes.icompras.curso.produtos.hexagonal.adapters.out;

import com.fernandes.icompras.curso.produtos.hexagonal.adapters.out.repository.ProdutoRepository;
import com.fernandes.icompras.curso.produtos.hexagonal.adapters.out.repository.mapper.ProdutoEntityMapper;
import com.fernandes.icompras.curso.produtos.hexagonal.application.core.domain.Produto;
import com.fernandes.icompras.curso.produtos.hexagonal.application.ports.out.ConsultaProdutoPorIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ConsultaProdutoPorIdAdapter implements ConsultaProdutoPorIdOutputPort {

    private final ProdutoRepository repository;

    private final ProdutoEntityMapper mapper;

    @Override
    public Optional<Produto> buscarPorCodigo(Long codigo) {
        var produtoEntity = repository.findById(codigo);
        return produtoEntity.map(mapper::toProduto);
    }
}
