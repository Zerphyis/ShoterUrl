package dev.Zerphyis.shortUrl.domain.entities;


import java.time.LocalDateTime;

public class UrlModel {

    private Long id;

    private String fullUrl;

    private String shortCode;

    private LocalDateTime expiresAt;

    public UrlModel(String fullUrl, String shortCode, LocalDateTime expiresAt) {
        this.fullUrl = fullUrl;
        this.shortCode = shortCode;
        this.expiresAt = expiresAt;
    }

    public Long getId() {
        return id;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public String getShortCode() {
        return shortCode;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }
}
