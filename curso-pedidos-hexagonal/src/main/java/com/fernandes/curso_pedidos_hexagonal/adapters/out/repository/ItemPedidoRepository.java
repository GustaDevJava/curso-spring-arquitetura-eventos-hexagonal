package com.fernandes.curso_pedidos_hexagonal.adapters.out.repository;

import com.fernandes.curso_pedidos_hexagonal.adapters.out.repository.entity.ItemPedidoEntity;
import com.fernandes.curso_pedidos_hexagonal.adapters.out.repository.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedidoEntity, Long> {

    List<ItemPedidoEntity> findByPedido(PedidoEntity pedidoEntity);
}
