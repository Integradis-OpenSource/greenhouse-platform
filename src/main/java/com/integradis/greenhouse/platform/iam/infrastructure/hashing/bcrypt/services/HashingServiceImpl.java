package com.integradis.greenhouse.platform.iam.infrastructure.hashing.bcrypt.services;

import com.integradis.greenhouse.platform.iam.infrastructure.hashing.bcrypt.BCryptHashingService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class HashingServiceImpl implements BCryptHashingService {
    private final BCryptPasswordEncoder passwordEncoder;

    public HashingServiceImpl(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String encode(CharSequence rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
