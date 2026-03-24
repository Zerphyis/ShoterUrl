package dev.Zerphyis.shortUrl.application.usecases;

import dev.Zerphyis.shortUrl.application.records.*;

public class ServiceUrl {

    private final CreateUrlUseCase createUrlUseCase;
    private final GetUrlByIdUseCase getUrlByIdUseCase;
    private final GetAllUrlUseCase getAllUrlsUseCase;
    private final DeleteUrlUseCase deleteUrlUseCase;
    private final RedirectUseCase redirectUrlUseCase;

    public ServiceUrl(
            CreateUrlUseCase createUrlUseCase,
            GetUrlByIdUseCase getUrlByIdUseCase,
            GetAllUrlUseCase getAllUrlsUseCase,
            DeleteUrlUseCase deleteUrlUseCase,
            RedirectUseCase redirectUrlUseCase
    ) {
        this.createUrlUseCase = createUrlUseCase;
        this.getUrlByIdUseCase = getUrlByIdUseCase;
        this.getAllUrlsUseCase = getAllUrlsUseCase;
        this.deleteUrlUseCase = deleteUrlUseCase;
        this.redirectUrlUseCase = redirectUrlUseCase;
    }

    public ShortenUrlResponse create(ShortenUrlRequest request, String baseUrl) {
        return createUrlUseCase.execute(request, baseUrl);
    }

    public GetUrlByIdResponse getById(Long id, String baseUrl) {
        return getUrlByIdUseCase.execute(id, baseUrl);
    }

    public GetAllUrlResponse getAll(String baseUrl) {
        return getAllUrlsUseCase.execute(baseUrl);
    }

    public DeleteUrlResponse delete(Long id) {
        return deleteUrlUseCase.execute(id);
    }

    public String redirect(String shortCode) {
        return redirectUrlUseCase.execute(shortCode);
    }
}