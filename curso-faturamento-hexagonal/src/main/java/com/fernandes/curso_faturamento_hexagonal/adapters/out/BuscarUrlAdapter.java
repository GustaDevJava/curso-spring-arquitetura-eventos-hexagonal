package com.fernandes.curso_faturamento_hexagonal.adapters.out;

import com.fernandes.curso_faturamento_hexagonal.adapters.out.bucket.Bucket;
import com.fernandes.curso_faturamento_hexagonal.application.ports.out.BuscarUrlOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BuscarUrlAdapter implements BuscarUrlOutputPort {

    private final Bucket bucket;

    @Override
    public String getUrl(String fileName) {
        return bucket.getUrl(fileName);
    }
}
