package dev.Zerphyis.shortUrl.domain.usecasesinterface;

import dev.Zerphyis.shortUrl.application.records.ShortenUrlRequest;
import dev.Zerphyis.shortUrl.application.records.ShortenUrlResponse;

public interface CreateUrlInterface {
    ShortenUrlResponse execute(ShortenUrlRequest request,String baseUrl);
}
