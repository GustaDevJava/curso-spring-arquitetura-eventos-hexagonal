package com.fernandes.curso_faturamento_hexagonal.adapters.in.api;

import com.fernandes.curso_faturamento_hexagonal.application.core.domain.file.BucketFile;
import com.fernandes.curso_faturamento_hexagonal.application.ports.in.BuscarUrlInputPort;
import com.fernandes.curso_faturamento_hexagonal.application.ports.in.UploadArquivoInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@RestController
@RequestMapping("/bucket")
@RequiredArgsConstructor
public class BucketController {

    private final UploadArquivoInputPort uploadArquivoInputPort;

    private final BuscarUrlInputPort buscarUrlInputPort;

    @PostMapping
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
        try(InputStream is = file.getInputStream()) {

            MediaType type = MediaType.parseMediaType(file.getContentType());
            var bucketFile = new BucketFile(file.getOriginalFilename(), is, type, file.getSize());
            uploadArquivoInputPort.upload(bucketFile);
            return ResponseEntity.ok("Arquivo enviado com sucesso!");
        }catch (Exception e){
            return ResponseEntity.status(500).body("Erro ao enviar arquivo: " + e.getMessage());
        }

    }

    @GetMapping
    public ResponseEntity<String> getUrl(@RequestParam String filename){
        try {
            String url = buscarUrlInputPort.getUrl(filename);
            return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).body(url);
        }catch (Exception e){
            return ResponseEntity.status(500).body("Erro ao obter URL do arquivo: " + e.getMessage());

        }
    }

}

