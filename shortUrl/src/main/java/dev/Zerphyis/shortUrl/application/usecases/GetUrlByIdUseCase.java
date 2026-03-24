package dev.Zerphyis.shortUrl.application.usecases;

import dev.Zerphyis.shortUrl.application.exceptions.UrlExpiredException;
import dev.Zerphyis.shortUrl.application.exceptions.UrlNotFoundException;
import dev.Zerphyis.shortUrl.application.records.GetUrlByIdResponse;
import dev.Zerphyis.shortUrl.domain.entities.UrlModel;
import dev.Zerphyis.shortUrl.domain.repository.UrlRepository;
import dev.Zerphyis.shortUrl.domain.usecasesinterface.GetUrlByidInterface;

import java.time.LocalDateTime;

public class GetUrlByIdUseCase implements GetUrlByidInterface {
    private final UrlRepository repository;

    public GetUrlByIdUseCase(UrlRepository repository) {
        this.repository = repository;
    }


    public GetUrlByIdResponse execute(Long id, String baseUrl) {

        UrlModel url = repository.findById(id)
                .orElseThrow(() -> new UrlNotFoundException(id));

        if (url.getExpiresAt() != null &&
                url.getExpiresAt().isBefore(LocalDateTime.now())) {
            throw new UrlExpiredException();
        }

        String shortUrl = buildShortUrl(baseUrl, url.getShortCode());

        return new GetUrlByIdResponse(
                url.getId(),
                url.getFullUrl(),
                shortUrl
        );
    }

    private String buildShortUrl(String baseUrl, String shortCode) {
        return baseUrl + "/" + shortCode;
    }
}
