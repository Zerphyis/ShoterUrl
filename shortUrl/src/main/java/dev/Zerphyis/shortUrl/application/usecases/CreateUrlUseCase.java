package dev.Zerphyis.shortUrl.application.usecases;

import dev.Zerphyis.shortUrl.application.records.ShortenUrlRequest;
import dev.Zerphyis.shortUrl.application.records.ShortenUrlResponse;
import dev.Zerphyis.shortUrl.domain.entities.UrlModel;
import dev.Zerphyis.shortUrl.domain.repository.UrlRepository;
import dev.Zerphyis.shortUrl.domain.usecasesinterface.CreateUrlInterface;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.util.InvalidUrlException;

import java.time.LocalDateTime;

public class CreateUrlUseCase implements CreateUrlInterface {
    private final UrlRepository repository;

    public CreateUrlUseCase(UrlRepository repository) {
        this.repository = repository;
    }

    @Override
    public ShortenUrlResponse execute(ShortenUrlRequest request, String baseUrl) {

        validate(request);

        String shortCode = generateUniqueShortCode();

        LocalDateTime expiresAt = LocalDateTime.now().plusDays(1);

        UrlModel url = new UrlModel(
                request.url(),
                shortCode,
                expiresAt
        );

        UrlModel saved = repository.save(url);

        return new ShortenUrlResponse(
                buildShortUrl(baseUrl, saved.getShortCode())
        );
    }

    private void validate(ShortenUrlRequest request) {
        if (request == null || StringUtils.isBlank(request.url())) {
            throw new InvalidUrlException("URL não pode ser vazia");
        }
    }

    private String generateUniqueShortCode() {
        String code;

        do {
            code = RandomStringUtils.randomAlphanumeric(6);
        } while (repository.existsByShortCode(code));

        return code;
    }

    private String buildShortUrl(String baseUrl, String code) {
        return String.format("%s/api/urls/r/%s", baseUrl, code);
    }
}