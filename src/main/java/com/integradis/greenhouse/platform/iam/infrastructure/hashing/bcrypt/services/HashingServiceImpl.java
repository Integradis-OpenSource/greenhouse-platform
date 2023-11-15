package com.integradis.greenhouse.platform.iam.infrastructure.hashing.bcrypt.services;

import com.integradis.greenhouse.platform.iam.application.internal.outboundservices.hashing.HashingService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class HashingServiceImpl implements HashingService {
    private final BCryptPasswordEncoder passwordEncoder;

    public HashingServiceImpl(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String encode(CharSequence rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }
}
