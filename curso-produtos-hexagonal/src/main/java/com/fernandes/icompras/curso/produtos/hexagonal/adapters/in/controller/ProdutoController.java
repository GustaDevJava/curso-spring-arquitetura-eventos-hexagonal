package com.fernandes.icompras.curso.produtos.hexagonal.adapters.in.controller;

import com.fernandes.icompras.curso.produtos.hexagonal.adapters.in.controller.mapper.ProdutoMapper;
import com.fernandes.icompras.curso.produtos.hexagonal.adapters.in.controller.request.ProdutoRequest;
import com.fernandes.icompras.curso.produtos.hexagonal.adapters.in.controller.response.ProdutoResponse;
import com.fernandes.icompras.curso.produtos.hexagonal.application.ports.in.ConsultaProdutoPorIdInputPort;
import com.fernandes.icompras.curso.produtos.hexagonal.application.ports.in.ExclusaoLogicaProdutoInputPort;
import com.fernandes.icompras.curso.produtos.hexagonal.application.ports.in.SalvarProdutoInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final SalvarProdutoInputPort salvarProdutoInputPort;

    private final ConsultaProdutoPorIdInputPort consultaProdutoPorIdInputPort;

    private final ExclusaoLogicaProdutoInputPort exclusaoLogicaProdutoInputPort;

    private final ProdutoMapper mapper;

    @PostMapping
    public ResponseEntity<ProdutoResponse> salvar(@RequestBody ProdutoRequest produtoRequest){
        var produto = mapper.toProduto(produtoRequest);
        produto = salvarProdutoInputPort.salvar(produto);
        return ResponseEntity.ok().body(mapper.toProdutoResponse(produto));
    }

    @GetMapping
    public ResponseEntity<ProdutoResponse> buscarPorCodigo(@RequestParam("codigo") Long codigo){
        var produto = consultaProdutoPorIdInputPort.buscarPorCodigo(codigo);
        var produtoResponse = mapper.toProdutoResponse(produto);
        return ResponseEntity.ok().body(produtoResponse);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletar(@RequestParam("codigo") Long codigo){
        exclusaoLogicaProdutoInputPort.deletar(codigo);
        return ResponseEntity.noContent().build();
    }
}
