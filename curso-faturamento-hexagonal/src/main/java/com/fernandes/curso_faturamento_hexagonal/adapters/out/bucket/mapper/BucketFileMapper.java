package com.fernandes.curso_faturamento_hexagonal.adapters.out.bucket.mapper;

import com.fernandes.curso_faturamento_hexagonal.adapters.out.bucket.file.BucketFileRepresentation;
import com.fernandes.curso_faturamento_hexagonal.application.core.domain.file.BucketFile;

public interface BucketFileMapper {

    BucketFileRepresentation toBucketFileRepresentation(BucketFile file);
}
