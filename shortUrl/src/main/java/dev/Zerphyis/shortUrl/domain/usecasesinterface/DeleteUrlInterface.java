package dev.Zerphyis.shortUrl.domain.usecasesinterface;

import dev.Zerphyis.shortUrl.application.records.DeleteUrlResponse;

public interface DeleteUrlInterface {
    DeleteUrlResponse execute(Long id);
}
