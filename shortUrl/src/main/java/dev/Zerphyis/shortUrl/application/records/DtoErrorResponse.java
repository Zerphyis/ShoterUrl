package dev.Zerphyis.shortUrl.application.records;

import java.time.LocalDateTime;

public record DtoErrorResponse(int status,
                               String error,
                               String message,
                               String path,
                               LocalDateTime timestamp) {
}
