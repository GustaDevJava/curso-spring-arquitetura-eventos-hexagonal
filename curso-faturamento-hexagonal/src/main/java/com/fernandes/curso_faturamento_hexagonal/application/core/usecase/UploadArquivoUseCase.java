package com.fernandes.curso_faturamento_hexagonal.application.core.usecase;

import com.fernandes.curso_faturamento_hexagonal.application.core.domain.file.BucketFile;
import com.fernandes.curso_faturamento_hexagonal.application.ports.in.UploadArquivoInputPort;
import com.fernandes.curso_faturamento_hexagonal.application.ports.out.UploadArquivoOutputPort;

public class UploadArquivoUseCase implements UploadArquivoInputPort {

    private final UploadArquivoOutputPort uploadArquivoOutputPort;

    public UploadArquivoUseCase(UploadArquivoOutputPort uploadArquivoOutputPort) {
        this.uploadArquivoOutputPort = uploadArquivoOutputPort;
    }

    @Override
    public void upload(BucketFile file) {
        uploadArquivoOutputPort.upload(file);
    }
}
