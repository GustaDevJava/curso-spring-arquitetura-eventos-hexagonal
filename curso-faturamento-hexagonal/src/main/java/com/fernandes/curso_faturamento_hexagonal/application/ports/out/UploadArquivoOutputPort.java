package com.fernandes.curso_faturamento_hexagonal.application.ports.out;

import com.fernandes.curso_faturamento_hexagonal.application.core.domain.file.BucketFile;

public interface UploadArquivoOutputPort {

    void upload(BucketFile file);
}
