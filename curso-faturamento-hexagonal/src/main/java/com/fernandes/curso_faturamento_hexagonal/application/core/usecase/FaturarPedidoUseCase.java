package com.fernandes.curso_faturamento_hexagonal.application.core.usecase;

import com.fernandes.curso_faturamento_hexagonal.application.core.domain.Pedido;
import com.fernandes.curso_faturamento_hexagonal.application.ports.in.FaturarPedidoInputPort;
import com.fernandes.curso_faturamento_hexagonal.application.ports.out.BuscarUrlOutputPort;
import com.fernandes.curso_faturamento_hexagonal.application.ports.out.FaturarPedidoOutputPort;
import com.fernandes.curso_faturamento_hexagonal.application.ports.out.GerarNotaFiscalOutputPort;

public class FaturarPedidoUseCase implements FaturarPedidoInputPort {

    private final GerarNotaFiscalOutputPort gerarNotaFiscalOutputPort;

    private final BuscarUrlOutputPort buscarUrlOutputPort;

    private final FaturarPedidoOutputPort faturarPedidoOutputPort;


    public FaturarPedidoUseCase(GerarNotaFiscalOutputPort gerarNotaFiscalOutputPort, BuscarUrlOutputPort buscarUrlOutputPort, FaturarPedidoOutputPort faturarPedidoOutputPort) {
        this.gerarNotaFiscalOutputPort = gerarNotaFiscalOutputPort;
        this.buscarUrlOutputPort = buscarUrlOutputPort;
        this.faturarPedidoOutputPort = faturarPedidoOutputPort;
    }

    @Override
    public void faturarPedido(Pedido pedido) {
        var nomeArquivo = gerarNotaFiscalOutputPort.gerarNotaFiscal(pedido);
        var urlNotaFiscal = buscarUrlOutputPort.getUrl(nomeArquivo);
        faturarPedidoOutputPort.publicar(pedido, urlNotaFiscal);
    }

}
