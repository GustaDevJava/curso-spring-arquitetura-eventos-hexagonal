package com.fernandes.icompras.curso.produtos.hexagonal.adapters.out.repository;

import com.fernandes.icompras.curso.produtos.hexagonal.adapters.out.repository.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
}
