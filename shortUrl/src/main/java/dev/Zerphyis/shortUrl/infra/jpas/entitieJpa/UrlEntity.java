package dev.Zerphyis.shortUrl.infra.jpas.entitieJpa;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
@Table(name = "urls")
public class UrlEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private String fullUrl;

    @NotBlank
    private String shortCode;

    @Column(name ="expires_at")
    private LocalDateTime expiresAt;

    public UrlEntity(String fullUrl,String shortCode ,LocalDateTime expiresAt) {
        this.fullUrl = fullUrl;
        this.shortCode = shortCode;
        this.expiresAt = expiresAt;
    }

    public UrlEntity( ) {
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }
}
