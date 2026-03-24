package dev.Zerphyis.shortUrl.infra.controller;

import dev.Zerphyis.shortUrl.application.records.DtoErrorResponse;
import dev.Zerphyis.shortUrl.application.exceptions.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class HandlerController {

    private DtoErrorResponse buildErrorResponse(
            HttpStatus status,
            String message,
            HttpServletRequest request
    ) {
        return new DtoErrorResponse(
                status.value(),
                status.getReasonPhrase(),
                message,
                request.getRequestURI(),
                LocalDateTime.now()
        );
    }

    @ExceptionHandler(InvalidFormatUrlException.class)
    public ResponseEntity<DtoErrorResponse> handleInvalidFormatUrl(
            InvalidFormatUrlException ex,
            HttpServletRequest request
    ) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status)
                .body(buildErrorResponse(status, ex.getMessage(), request));
    }

    @ExceptionHandler(InvalidUrlException.class)
    public ResponseEntity<DtoErrorResponse> handleInvalidUrl(
            InvalidUrlException ex,
            HttpServletRequest request
    ) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status)
                .body(buildErrorResponse(status, ex.getMessage(), request));
    }

    @ExceptionHandler(UrlExpiredException.class)
    public ResponseEntity<DtoErrorResponse> handleUrlExpired(
            UrlExpiredException ex,
            HttpServletRequest request
    ) {
        HttpStatus status = HttpStatus.GONE;
        return ResponseEntity.status(status)
                .body(buildErrorResponse(status, ex.getMessage(), request));
    }

    @ExceptionHandler(UrlNotFoundException.class)
    public ResponseEntity<DtoErrorResponse> handleUrlNotFound(
            UrlNotFoundException ex,
            HttpServletRequest request
    ) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status)
                .body(buildErrorResponse(status, ex.getMessage(), request));
    }

    @ExceptionHandler(UrlNotFoundShortCodeException.class)
    public ResponseEntity<DtoErrorResponse> handleShortCodeNotFound(
            UrlNotFoundShortCodeException ex,
            HttpServletRequest request
    ) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status)
                .body(buildErrorResponse(status, ex.getMessage(), request));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<DtoErrorResponse> handleGenericException(
            Exception ex,
            HttpServletRequest request
    ) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        return ResponseEntity.status(status)
                .body(buildErrorResponse(
                        status,
                        "Erro interno inesperado",
                        request
                ));
    }
}