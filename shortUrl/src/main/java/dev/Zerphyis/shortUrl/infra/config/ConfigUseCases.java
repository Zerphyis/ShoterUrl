package dev.Zerphyis.shortUrl.infra.config;

import dev.Zerphyis.shortUrl.application.usecases.*;
import dev.Zerphyis.shortUrl.domain.repository.UrlRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigUseCases {

    @Bean
    public CreateUrlUseCase createUrlUseCase(UrlRepository repository) {
        return new CreateUrlUseCase(repository);
    }

    @Bean
    public GetUrlByIdUseCase getUrlByIdUseCase(UrlRepository repository) {
        return new GetUrlByIdUseCase(repository);
    }

    @Bean
    public GetAllUrlUseCase getAllUrlsUseCase(UrlRepository repository) {
        return new GetAllUrlUseCase(repository);
    }

    @Bean
    public DeleteUrlUseCase deleteUrlUseCase(UrlRepository repository) {
        return new DeleteUrlUseCase(repository);
    }

    @Bean
    public RedirectUseCase redirectUrlUseCase(UrlRepository repository) {
        return new RedirectUseCase(repository);
    }

    @Bean
    public ServiceUrl urlService(
            CreateUrlUseCase createUrlUseCase,
            GetUrlByIdUseCase getUrlByIdUseCase,
            GetAllUrlUseCase getAllUrlsUseCase,
            DeleteUrlUseCase deleteUrlUseCase,
            RedirectUseCase redirectUrlUseCase
    ) {
        return new ServiceUrl(
                createUrlUseCase,
                getUrlByIdUseCase,
                getAllUrlsUseCase,
                deleteUrlUseCase,
                redirectUrlUseCase
        );
    }
}
