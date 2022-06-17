package com.ird.faa.security.common;

public interface SecurityParams {
    String JWT_HEADER_NAME = "Authorization";
    String SECRET = "491db2ca-7680-4f86-b21b-5e1c5b26e547";
    long EXPIRATION = 86400000;
    String HEADER_PREFIX = "Bearer ";
}
