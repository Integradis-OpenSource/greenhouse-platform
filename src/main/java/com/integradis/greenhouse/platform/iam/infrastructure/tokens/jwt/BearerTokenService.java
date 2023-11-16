package com.integradis.greenhouse.platform.iam.infrastructure.tokens.jwt;

import com.integradis.greenhouse.platform.iam.application.internal.outboundservices.tokens.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;

public interface BearerTokenService extends TokenService {
    String generateToken(Authentication authentication);

    String getBearerTokenFrom(HttpServletRequest request);
}
