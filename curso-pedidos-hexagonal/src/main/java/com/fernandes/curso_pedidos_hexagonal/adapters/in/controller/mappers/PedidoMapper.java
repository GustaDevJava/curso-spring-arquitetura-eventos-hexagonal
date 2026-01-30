package com.fernandes.curso_pedidos_hexagonal.adapters.in.controller.mappers;


import com.fernandes.curso_pedidos_hexagonal.adapters.in.controller.dto.ItemPedidoDTO;
import com.fernandes.curso_pedidos_hexagonal.adapters.in.controller.dto.NovoPedidoDTO;
import com.fernandes.curso_pedidos_hexagonal.application.core.domain.ItemPedido;
import com.fernandes.curso_pedidos_hexagonal.application.core.domain.Pedido;
import com.fernandes.curso_pedidos_hexagonal.application.core.domain.enums.StatusPedido;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    ItemPedidoMapper ITEM_PEDIDO_MAPPER = Mappers.getMapper(ItemPedidoMapper.class);

    @Mapping(source = "itens", target = "itens", qualifiedByName = "mapItens")
    @Mapping(source = "dadosPagamento", target = "dadosPagamento")
    @Mapping(target = "codigo", ignore = true)
    @Mapping(target = "dataPedido", ignore = true)
    @Mapping(target = "total", ignore = true)
    @Mapping(target = "chavePagamento", ignore = true)
    @Mapping(target = "observacoes", ignore = true)
    @Mapping(target = "codigoRastreio", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "dadosCliente", ignore = true)
    Pedido toPedido(NovoPedidoDTO novoPedidoDTO);

    @Named("mapItens")
    default List<ItemPedido> mapItens(List<ItemPedidoDTO> dtos){
        return dtos.stream().map(ITEM_PEDIDO_MAPPER::toItemPedido).toList();
    }

    @AfterMapping
    default void afertMapping(@MappingTarget Pedido pedido){
        pedido.setStatus(StatusPedido.REALIZADO);
        pedido.setDataPedido(LocalDateTime.now());

        var total = calcularTotal(pedido);
        pedido.setTotal(total);
        pedido.getItens().forEach(item -> item.setCodigoPedido(pedido.getCodigo()));
    }

    private static BigDecimal calcularTotal(Pedido pedido) {
        return pedido.getItens().stream().map(itemPedido ->
                        itemPedido.getValorUnitario().multiply(BigDecimal.valueOf(itemPedido.getQuantidade())))
                .reduce(BigDecimal.ZERO, BigDecimal::add).abs();
    }
}
