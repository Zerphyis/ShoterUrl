package dev.Zerphyis.shortUrl.infra.jpas.repositoryJpa.adapter;

import dev.Zerphyis.shortUrl.domain.entities.UrlModel;
import dev.Zerphyis.shortUrl.domain.repository.UrlRepository;
import dev.Zerphyis.shortUrl.infra.jpas.Mappers.UrlMapper;
import dev.Zerphyis.shortUrl.infra.jpas.entitieJpa.UrlEntity;
import dev.Zerphyis.shortUrl.infra.jpas.repositoryJpa.UrlRepositoryJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UrlRepositoryAdapter implements UrlRepository {

    private final UrlRepositoryJpa jpaRepository;

    public UrlRepositoryAdapter(UrlRepositoryJpa jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public UrlModel save(UrlModel url) {
        UrlEntity entity = UrlMapper.toEntity(url);
        UrlEntity saved = jpaRepository.save(entity);
        return UrlMapper.toModel(saved);
    }

    @Override
    public Optional<UrlModel> findById(Long id) {
        return jpaRepository.findById(id)
                .map(UrlMapper::toModel);
    }

    @Override
    public Optional<UrlModel> findByShortCode(String shortCode) {
        return jpaRepository.findByShortCode(shortCode)
                .map(UrlMapper::toModel);
    }

    @Override
    public List<UrlModel> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(UrlMapper::toModel)
                .toList();
    }

    @Override
    public boolean existsByShortCode(String shortCode) {
        return jpaRepository.existsByShortCode(shortCode);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}
