package com.fernandes.curso_pedidos_hexagonal.adapters.out.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "item_pedido")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @JoinColumn (name = "codigo_pedido")
    @ManyToOne
    private PedidoEntity pedido;

    @Column(name = "codigo_produto")
    private Long codigoProduto;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "valor_unitarios", precision = 16, scale = 2)
    private BigDecimal valorUnitario;
}
