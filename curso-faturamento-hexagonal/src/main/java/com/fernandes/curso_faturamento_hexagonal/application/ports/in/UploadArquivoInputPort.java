package com.fernandes.curso_faturamento_hexagonal.application.ports.in;

import com.fernandes.curso_faturamento_hexagonal.application.core.domain.file.BucketFile;

public interface UploadArquivoInputPort {

    void upload(BucketFile file);
}
