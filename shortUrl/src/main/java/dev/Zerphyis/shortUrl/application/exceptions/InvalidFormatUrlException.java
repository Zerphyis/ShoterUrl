package dev.Zerphyis.shortUrl.application.exceptions;

public class InvalidFormatUrlException extends RuntimeException {
    public InvalidFormatUrlException(String message) {
        super(message);
    }
}
