package org.example.SmartAssign.services;

import org.example.SmartAssign.models.RefreshToken;


public interface IRefreshTokenService {
    boolean ValidToken(String token);
    RefreshToken createRefreshToken(String email, long expiration);
}
