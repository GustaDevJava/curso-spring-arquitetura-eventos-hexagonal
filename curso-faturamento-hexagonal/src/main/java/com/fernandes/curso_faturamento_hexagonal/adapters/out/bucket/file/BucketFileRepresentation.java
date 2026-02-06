package com.fernandes.curso_faturamento_hexagonal.adapters.out.bucket.file;

import org.springframework.http.MediaType;

import java.io.InputStream;

public record BucketFileRepresentation(String name, InputStream is, MediaType type, long size) {
}
