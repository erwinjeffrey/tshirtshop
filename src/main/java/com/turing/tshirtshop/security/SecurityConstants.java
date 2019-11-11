package com.turing.tshirtshop.security;

public class SecurityConstants {

    public static final String SECRET = "SecretKeyToGenJWTs";

    public static final long EXPIRATION_TIME = 86_400_000; // 24 hours

    public static final String TOKEN_PREFIX = "Bearer ";

    public static final String HEADER_STRING = "USER-KEY";

    public static final String SIGN_UP_URL = "/customers";


}
