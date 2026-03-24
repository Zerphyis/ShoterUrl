package dev.Zerphyis.shortUrl.domain.usecasesinterface;

import dev.Zerphyis.shortUrl.application.records.GetUrlByIdResponse;

public interface GetUrlByidInterface {
    GetUrlByIdResponse execute(Long id,String baseUrl);
}
