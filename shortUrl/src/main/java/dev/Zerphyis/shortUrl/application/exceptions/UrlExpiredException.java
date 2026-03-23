package dev.Zerphyis.shortUrl.application.exceptions;

public class UrlExpiredException extends RuntimeException {
    public UrlExpiredException() {
        super("URL está expirada");
    }
}
