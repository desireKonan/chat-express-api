package com.chat.domain.model;

import java.time.Instant;

import org.springframework.data.annotation.Id;

public class PersonnalAccessToken {
    @Id
    private Long id;
    private Long userId;
    private String tokenName;
    private String tokenValue;
    private Instant expiredAt;
    private Instant createdAt;

    public PersonnalAccessToken(Long id, Long userId, String tokenName, String tokenValue, Instant expiredAt, Instant createdAt) {
        this.id = id;
        this.userId = userId;
        this.tokenName = tokenName;
        this.tokenValue = tokenValue;
        this.createdAt = createdAt;
        this.expiredAt = expiredAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTokenName() {
        return tokenName;
    }

    public void setTokenName(String tokenName) {
        this.tokenName = tokenName;
    }

    public String getTokenValue() {
        return tokenValue;
    }

    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }

    public Instant getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(Instant expiredAt) {
        this.expiredAt = expiredAt;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "PersonnalAccessToken {" +
                "id = " + id +
                ", userId = " + userId +
                ", tokenName = '" + tokenName + '\'' +
                ", tokenValue = '" + tokenValue + '\'' +
                ", expiredAt = " + expiredAt +
                ", createdAt = " + createdAt +
        '}';
    }
}
