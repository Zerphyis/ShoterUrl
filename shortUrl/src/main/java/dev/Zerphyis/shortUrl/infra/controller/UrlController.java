package dev.Zerphyis.shortUrl.infra.controller;

import dev.Zerphyis.shortUrl.application.records.*;
import dev.Zerphyis.shortUrl.application.usecases.ServiceUrl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/urls")
public class UrlController {

    private final ServiceUrl service;

    public UrlController(ServiceUrl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ShortenUrlResponse> create(@RequestBody ShortenUrlRequest request) {

        String baseUrl = getBaseUrl();

        ShortenUrlResponse response = service.create(request, baseUrl);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetUrlByIdResponse> getById(@PathVariable Long id) {

        String baseUrl = getBaseUrl();

        return ResponseEntity.ok(service.getById(id, baseUrl));
    }

    @GetMapping
    public ResponseEntity<GetAllUrlResponse> getAll() {

        String baseUrl = getBaseUrl();

        return ResponseEntity.ok(service.getAll(baseUrl));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteUrlResponse> delete(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping("/r/{code}")
    public ResponseEntity<Void> redirect(@PathVariable String code) {

        String url = service.redirect(code);

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(URI.create(url))
                .build();
    }

    private String getBaseUrl() {
        return ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .build()
                .toUriString();
    }
}