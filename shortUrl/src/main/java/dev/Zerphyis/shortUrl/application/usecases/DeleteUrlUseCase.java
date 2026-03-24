package dev.Zerphyis.shortUrl.application.usecases;

import dev.Zerphyis.shortUrl.application.exceptions.UrlNotFoundException;
import dev.Zerphyis.shortUrl.application.records.DeleteUrlResponse;
import dev.Zerphyis.shortUrl.domain.repository.UrlRepository;
import dev.Zerphyis.shortUrl.domain.usecasesinterface.DeleteUrlInterface;

public class DeleteUrlUseCase implements DeleteUrlInterface {
    private final UrlRepository repository;

    public DeleteUrlUseCase(UrlRepository repository) {
        this.repository = repository;
    }

    public DeleteUrlResponse execute(Long id) {

        repository.findById(id)
                .orElseThrow(() -> new UrlNotFoundException(id));

        repository.deleteById(id);

        return new DeleteUrlResponse("URL deletada com sucesso");
    }
}

