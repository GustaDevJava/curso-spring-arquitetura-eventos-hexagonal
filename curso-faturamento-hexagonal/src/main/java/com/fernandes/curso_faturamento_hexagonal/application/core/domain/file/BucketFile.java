package com.fernandes.curso_faturamento_hexagonal.application.core.domain.file;

import org.springframework.http.MediaType;

import java.io.InputStream;

public class BucketFile {

    private String name;
    private InputStream is;
    private MediaType type;
    private long size;

    public BucketFile(){}

    public BucketFile(String name, InputStream is, MediaType type, long size) {
        this.name = name;
        this.is = is;
        this.type = type;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InputStream getIs() {
        return is;
    }

    public void setIs(InputStream is) {
        this.is = is;
    }

    public MediaType getType() {
        return type;
    }

    public void setType(MediaType type) {
        this.type = type;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
