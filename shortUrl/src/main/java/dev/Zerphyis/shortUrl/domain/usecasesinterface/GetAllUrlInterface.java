package dev.Zerphyis.shortUrl.domain.usecasesinterface;

import dev.Zerphyis.shortUrl.application.records.GetAllUrlResponse;

public interface GetAllUrlInterface {
    GetAllUrlResponse execute(String baseUrl);
}
