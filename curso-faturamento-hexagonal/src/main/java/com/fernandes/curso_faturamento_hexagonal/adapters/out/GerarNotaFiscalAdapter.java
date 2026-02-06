package com.fernandes.curso_faturamento_hexagonal.adapters.out;

import com.fernandes.curso_faturamento_hexagonal.adapters.out.bucket.Bucket;
import com.fernandes.curso_faturamento_hexagonal.adapters.out.bucket.file.BucketFileRepresentation;
import com.fernandes.curso_faturamento_hexagonal.adapters.out.jasper.Jaspersoft;
import com.fernandes.curso_faturamento_hexagonal.adapters.out.jasper.mapper.PedidoNotaMapper;
import com.fernandes.curso_faturamento_hexagonal.application.core.domain.Pedido;
import com.fernandes.curso_faturamento_hexagonal.application.ports.out.GerarNotaFiscalOutputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;

@Slf4j
@Component
@RequiredArgsConstructor
public class GerarNotaFiscalAdapter implements GerarNotaFiscalOutputPort {

    private final Jaspersoft jaspersoft;

    private final Bucket bucket;

    private final PedidoNotaMapper mapper;

    @Override
    public String gerarNotaFiscal(Pedido pedido) {
        log.info("Gerada nota fiscal para o pedido {}", pedido.getCodigo());
        String nomeArquivo = String.format("notafiscal_pedido_%d.pdf", pedido.getCodigo());
        try {
            var pedidoNota = mapper.toPedidoNota(pedido);
            byte[] byteArray = jaspersoft.gerarNota(pedidoNota);

            var file = new BucketFileRepresentation(nomeArquivo, new ByteArrayInputStream(byteArray), MediaType.APPLICATION_PDF,
                    byteArray.length);

            bucket.upload(file);

            log.info("Gerada a nota fiscal, nome do arquivo: {}", nomeArquivo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return nomeArquivo;
    }
}
