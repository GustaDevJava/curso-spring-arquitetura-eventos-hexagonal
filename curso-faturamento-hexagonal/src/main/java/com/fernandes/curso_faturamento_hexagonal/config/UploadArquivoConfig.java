package com.fernandes.curso_faturamento_hexagonal.config;

import com.fernandes.curso_faturamento_hexagonal.adapters.out.UploadArquivoAdapter;
import com.fernandes.curso_faturamento_hexagonal.application.core.usecase.UploadArquivoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UploadArquivoConfig {

    @Bean
    public UploadArquivoUseCase uploadArquivoUseCase(
            UploadArquivoAdapter uploadArquivoAdapter
    ){
        return new UploadArquivoUseCase(uploadArquivoAdapter);
    }
}
