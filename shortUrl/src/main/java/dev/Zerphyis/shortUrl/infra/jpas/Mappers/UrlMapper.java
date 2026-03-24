package dev.Zerphyis.shortUrl.infra.jpas.Mappers;

import dev.Zerphyis.shortUrl.domain.entities.UrlModel;
import dev.Zerphyis.shortUrl.infra.jpas.entitieJpa.UrlEntity;

public class UrlMapper {
    public static UrlModel toModel(UrlEntity entity) {
        if (entity == null) return null;

        UrlModel model = new UrlModel(
                entity.getFullUrl(),
                entity.getShortCode(),
                entity.getExpiresAt()
        );

        model.setId(entity.getId());

        return model;
    }

    public static UrlEntity toEntity(UrlModel model) {
        if (model == null) return null;

        UrlEntity entity = new UrlEntity(
                model.getFullUrl(),
                model.getShortCode(),
                model.getExpiresAt()
        );

        entity.setId(model.getId());

        return entity;
    }
}
