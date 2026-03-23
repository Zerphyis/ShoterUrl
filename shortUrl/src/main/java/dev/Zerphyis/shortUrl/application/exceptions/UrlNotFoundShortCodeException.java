package dev.Zerphyis.shortUrl.application.exceptions;

public class UrlNotFoundShortCodeException extends RuntimeException {
    public UrlNotFoundShortCodeException(String shortCode) {
        super("URL encurtada " + shortCode + " não encontrada");
    }
}
