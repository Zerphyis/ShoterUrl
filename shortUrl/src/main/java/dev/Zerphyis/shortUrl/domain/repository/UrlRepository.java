package dev.Zerphyis.shortUrl.domain.repository;

import dev.Zerphyis.shortUrl.domain.entities.UrlModel;

import java.util.List;
import java.util.Optional;

public interface UrlRepository {
    UrlModel save(UrlModel url);

    Optional<UrlModel> findById(Long id);

    Optional<UrlModel> findByShortCode(String shortCode);

    boolean existsByShortCode(String shortCode);

    void deleteById(Long id);

    List<UrlModel> findAll();
}
