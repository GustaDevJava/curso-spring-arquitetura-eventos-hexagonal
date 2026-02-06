package com.fernandes.curso_faturamento_hexagonal.adapters.out;

import com.fernandes.curso_faturamento_hexagonal.adapters.out.bucket.Bucket;
import com.fernandes.curso_faturamento_hexagonal.adapters.out.bucket.mapper.BucketFileMapper;
import com.fernandes.curso_faturamento_hexagonal.application.core.domain.file.BucketFile;
import com.fernandes.curso_faturamento_hexagonal.application.ports.out.UploadArquivoOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UploadArquivoAdapter implements UploadArquivoOutputPort {

    private final Bucket bucket;

    private final BucketFileMapper mapper;

    @Override
    public void upload(BucketFile file) {
        var bucketRepresentation = mapper.toBucketFileRepresentation(file);
        bucket.upload(bucketRepresentation);
    }
}
