package org.example.SmartAssign.serviceImpls;

import org.example.SmartAssign.models.RefreshToken;
import org.example.SmartAssign.repositories.RefreshTokenRepository;
import org.example.SmartAssign.repositories.UserRepository;
import org.example.SmartAssign.services.IRefreshTokenService;
import org.example.SmartAssign.services.IUserService;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class RefreshTokenServiceImpl implements IRefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;
    private final IUserService userService;
    private final UserRepository userRepository;

    public RefreshTokenServiceImpl(RefreshTokenRepository refreshTokenRepository, IUserService userService, UserRepository userRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @Override
    public boolean ValidToken(String token) {
        RefreshToken refreshToken = refreshTokenRepository.findByToken(token);
        return refreshToken != null && refreshToken.getExpiryDate().isAfter(Instant.now())&&userService.ValidUser(refreshToken.getUser().getEmail());
    }

    @Override
    public RefreshToken createRefreshToken(String email, long expiration) {
        RefreshToken refreshToken = RefreshToken.builder()
                .user(userRepository.findUserByEmail(email))
                .token(java.util.UUID.randomUUID().toString())
                .expiryDate(Instant.now().plusMillis(expiration))
                .build();
        return refreshTokenRepository.save(refreshToken);
    }
}
