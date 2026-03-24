package dev.Zerphyis.shortUrl.application.records;

import java.util.List;

public record GetAllUrlResponse(List<GetUrlByIdResponse> urls) {
}
