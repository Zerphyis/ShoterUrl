package dev.Zerphyis.shortUrl.application.usecases;

import dev.Zerphyis.shortUrl.application.exceptions.InvalidFormatUrlException;
import dev.Zerphyis.shortUrl.application.exceptions.UrlExpiredException;
import dev.Zerphyis.shortUrl.domain.entities.UrlModel;
import dev.Zerphyis.shortUrl.domain.repository.UrlRepository;

import java.time.LocalDateTime;

public class RedirectUseCase {
    private final UrlRepository repository;


    public RedirectUseCase(UrlRepository repository) {
        this.repository = repository;
    }

    public String execute(String shortCode) {

        UrlModel url = repository.findByShortCode(shortCode)
                .orElseThrow(() -> new InvalidFormatUrlException("Short code não encontrado"));

        if (isExpired(url)) {
            throw new UrlExpiredException();
        }

        return url.getFullUrl();
    }

    private boolean isExpired(UrlModel url) {
        return url.getExpiresAt() != null &&
                url.getExpiresAt().isBefore(LocalDateTime.now());
    }
}
