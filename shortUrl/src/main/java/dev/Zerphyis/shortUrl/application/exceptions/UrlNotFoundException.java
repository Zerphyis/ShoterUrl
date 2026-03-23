package dev.Zerphyis.shortUrl.application.exceptions;

public class UrlNotFoundException extends RuntimeException {
    public UrlNotFoundException(Long id) {
        super("URL com id " + id + " não encontrada");
    }
}
