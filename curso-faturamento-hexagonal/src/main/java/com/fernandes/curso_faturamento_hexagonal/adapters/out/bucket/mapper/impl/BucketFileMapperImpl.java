package com.fernandes.curso_faturamento_hexagonal.adapters.out.bucket.mapper.impl;

import com.fernandes.curso_faturamento_hexagonal.adapters.out.bucket.file.BucketFileRepresentation;
import com.fernandes.curso_faturamento_hexagonal.adapters.out.bucket.mapper.BucketFileMapper;
import com.fernandes.curso_faturamento_hexagonal.application.core.domain.file.BucketFile;
import org.springframework.stereotype.Component;

@Component
public class BucketFileMapperImpl implements BucketFileMapper {


    @Override
    public BucketFileRepresentation toBucketFileRepresentation(BucketFile file) {
        return new BucketFileRepresentation(file.getName(), file.getIs(), file.getType(), file.getSize());
    }
}
