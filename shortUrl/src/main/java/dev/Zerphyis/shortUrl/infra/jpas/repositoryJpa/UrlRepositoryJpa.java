package dev.Zerphyis.shortUrl.infra.jpas.repositoryJpa;

import dev.Zerphyis.shortUrl.infra.jpas.entitieJpa.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepositoryJpa extends JpaRepository<UrlEntity, Long> {
    Optional<UrlEntity> findByShortCode(String shortCode);

    boolean existsByShortCode(String shortCode);
}
