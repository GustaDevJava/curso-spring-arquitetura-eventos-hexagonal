package com.fernandes.curso_pedidos_hexagonal.adapters.out.client.mapper;

import com.fernandes.curso_pedidos_hexagonal.adapters.out.client.representation.ProdutoRepresentation;
import com.fernandes.curso_pedidos_hexagonal.application.core.domain.Produto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProdutoRepresentationMapper {

    Produto toProduto(ProdutoRepresentation produtoRepresentation);
}
