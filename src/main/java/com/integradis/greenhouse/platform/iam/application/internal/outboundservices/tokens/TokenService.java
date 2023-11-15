package com.integradis.greenhouse.platform.iam.application.internal.outboundservices.tokens;

import org.springframework.security.core.Authentication;

public interface TokenService {
    String generateToken(String username);
    String getUsernameFromToken(String token);
    boolean validateToken(String token);
}
