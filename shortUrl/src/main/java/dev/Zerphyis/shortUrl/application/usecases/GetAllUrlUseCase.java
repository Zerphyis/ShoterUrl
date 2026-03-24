package dev.Zerphyis.shortUrl.application.usecases;

import dev.Zerphyis.shortUrl.application.records.GetAllUrlResponse;
import dev.Zerphyis.shortUrl.application.records.GetUrlByIdResponse;
import dev.Zerphyis.shortUrl.domain.entities.UrlModel;
import dev.Zerphyis.shortUrl.domain.repository.UrlRepository;
import dev.Zerphyis.shortUrl.domain.usecasesinterface.GetAllUrlInterface;

import java.util.List;
import java.util.stream.Collectors;

public class GetAllUrlUseCase implements GetAllUrlInterface {
    private final UrlRepository repository;

    public GetAllUrlUseCase(UrlRepository repository) {
        this.repository = repository;
    }


    @Override
    public GetAllUrlResponse execute(String baseUrl) {

        List<GetUrlByIdResponse> urls = repository.findAll()
                .stream()
                .map(url -> mapToResponse(url, baseUrl))
                .collect(Collectors.toList());

        return new GetAllUrlResponse(urls);
    }

    private GetUrlByIdResponse mapToResponse(UrlModel url, String baseUrl) {
        return new GetUrlByIdResponse(
                url.getId(),
                url.getFullUrl(),
                buildShortUrl(baseUrl, url.getShortCode())
        );
    }

    private String buildShortUrl(String baseUrl, String shortCode) {
        return baseUrl + "/" + shortCode;
    }
}
