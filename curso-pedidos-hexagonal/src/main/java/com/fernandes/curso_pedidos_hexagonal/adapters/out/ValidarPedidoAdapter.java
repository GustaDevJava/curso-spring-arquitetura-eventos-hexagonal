package com.fernandes.curso_pedidos_hexagonal.adapters.out;

import com.fernandes.curso_pedidos_hexagonal.adapters.out.client.ClientesClient;
import com.fernandes.curso_pedidos_hexagonal.adapters.out.client.ProdutosClient;
import com.fernandes.curso_pedidos_hexagonal.adapters.out.client.mapper.ClienteRepresentationMapper;
import com.fernandes.curso_pedidos_hexagonal.adapters.out.client.mapper.ProdutoRepresentationMapper;
import com.fernandes.curso_pedidos_hexagonal.adapters.out.client.representation.ClienteRepresentation;
import com.fernandes.curso_pedidos_hexagonal.adapters.out.client.representation.ProdutoRepresentation;
import com.fernandes.curso_pedidos_hexagonal.application.core.domain.Cliente;
import com.fernandes.curso_pedidos_hexagonal.application.core.domain.Produto;
import com.fernandes.curso_pedidos_hexagonal.application.core.exception.ValidationException;
import com.fernandes.curso_pedidos_hexagonal.application.ports.out.BuscarClienteOutputPort;
import com.fernandes.curso_pedidos_hexagonal.application.ports.out.BuscarProdutoOutputPort;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ValidarPedidoAdapter implements BuscarClienteOutputPort, BuscarProdutoOutputPort {

    private final ClientesClient clientesClient;

    private final ClienteRepresentationMapper clienteRepresentationMapper;

    private final ProdutosClient produtosClient;

    private final ProdutoRepresentationMapper produtoRepresentationMapper;

    @Override
    public Cliente obterDadosCliente(Long codigoCliente) {
        try {
            var response = clientesClient.cadastrarCliente(codigoCliente);
            ClienteRepresentation cliente = response.getBody();
            log.info("Cliente de código {} encontrado: {}",cliente.codigo(), cliente.nome());
            return clienteRepresentationMapper.toCliente(response.getBody());
        }catch (FeignException.NotFound e){
            log.error("Cliente não encontrado!");
            var message = String.format("Cliente de codigo %d não encontrado!", codigoCliente);
            throw new ValidationException("codigoCliente",message);
        }
    }

    @Override
    public Produto obterDadosProduto(Long codigoProduto) {
        try {
            var response = produtosClient.buscarPorCodigo(codigoProduto);
            ProdutoRepresentation produto = response.getBody();
            log.info("Produto de código {} encontrado: {}",produto.codigo(), produto.nome());
            return produtoRepresentationMapper.toProduto(produto);
        }catch (FeignException.NotFound e){
            log.error("Produto não encontrado!");
            var message = String.format("Produto de codigo %d não encontrado!", codigoProduto);
            throw new ValidationException("codigoProduto",message);
        }
    }
}
