package com.fernandes.curso_faturamento_hexagonal.adapters.out.jasper;

import com.fernandes.curso_faturamento_hexagonal.adapters.out.jasper.representation.PedidoNotaRepresentation;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Component
public class Jaspersoft {

    @Value("classpath:reports/nota-fiscal.jrxml")
    private Resource notaFiscal;

    @Value("classpath:reports/logo.png")
    private Resource logo;

    public byte[] gerarNota(PedidoNotaRepresentation representation){
        try (InputStream inputStream = notaFiscal.getInputStream()){

            Map<String, Object> params = new HashMap<>();
            params.put("NOME", representation.nome());
            params.put("CPF", representation.cpf());
            params.put("LOGRADOURO", representation.logradouro());
            params.put("NUMERO", representation.numero());
            params.put("BAIRRO", representation.bairro());
            params.put("EMAIL", representation.email());
            params.put("TELEFONE", representation.telefone());

            params.put("DATA_PEDIDO", representation.dataPedido());
            params.put("TOTAL_PEDIDO", representation.total());

            params.put("LOGO", logo.getFile().getAbsolutePath());

            var dataSource = new JRBeanCollectionDataSource(representation.itens());

            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);

            return JasperExportManager.exportReportToPdf(jasperPrint);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
