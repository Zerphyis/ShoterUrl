package dev.Zerphyis.shortUrl.application.records;

public record GetUrlByIdResponse(Long id,
                                 String fullUrl,
                                 String shortUrl) {
}
