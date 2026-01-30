package com.fernandes.curso_pedidos_hexagonal.adapters.out.repository;

import com.fernandes.curso_pedidos_hexagonal.adapters.out.repository.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {

    Optional<PedidoEntity> findByCodigoAndChavePagamento(Long codigo, String chavePagamento);
}
