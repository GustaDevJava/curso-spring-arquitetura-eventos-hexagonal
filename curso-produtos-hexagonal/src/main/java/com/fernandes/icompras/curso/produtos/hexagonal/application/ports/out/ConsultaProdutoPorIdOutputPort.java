package com.fernandes.icompras.curso.produtos.hexagonal.application.ports.out;

import com.fernandes.icompras.curso.produtos.hexagonal.application.core.domain.Produto;

import java.util.Optional;

public interface ConsultaProdutoPorIdOutputPort {

    Optional<Produto> buscarPorCodigo(Long codigo);
}
