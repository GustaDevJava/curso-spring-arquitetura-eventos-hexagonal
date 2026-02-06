package com.fernandes.curso_logistica_hexagonal.application.core.usecase;

import com.fernandes.curso_logistica_hexagonal.application.core.domain.DadosPedido;
import com.fernandes.curso_logistica_hexagonal.application.core.domain.enums.StatusPedido;
import com.fernandes.curso_logistica_hexagonal.application.ports.in.EnvioPedidoInputPort;
import com.fernandes.curso_logistica_hexagonal.application.ports.out.EnvioPedidoOutputPort;

import java.util.Random;

public class EnvioPedidoUseCase implements EnvioPedidoInputPort {

    private final EnvioPedidoOutputPort envioPedidoOutputPort;

    public EnvioPedidoUseCase(EnvioPedidoOutputPort envioPedidoOutputPort) {
        this.envioPedidoOutputPort = envioPedidoOutputPort;
    }

    @Override
    public void enviar(Long codigoPedido, String urlNotaFiscal) {
        var codigoRastreio = gerarCodigoRastreio();
        var dadosPedido = new DadosPedido(
                codigoPedido,
                StatusPedido.ENVIADO,
                urlNotaFiscal,
                codigoRastreio);
        envioPedidoOutputPort.enviar(dadosPedido);
    }

    private String gerarCodigoRastreio() {
        var random = new Random();

        char letra1 = (char) ('A' + random.nextInt(26));
        char letra2 = (char) ('A' + random.nextInt(26));

        int numeros = 100000000 + random.nextInt(900000000);
        return ""+ letra1 +letra2 + numeros + "BR";

    }
}
