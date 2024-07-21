package com.weather.demo.authprovider;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class RequestHeaderAuthenticationProvider implements AuthenticationProvider {

    @Value("${api.auth.clientid}")
    private String apiClientId;

    @Value("${api.auth.secret}")
    private String apiAuthSecret;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String clientId = String.valueOf(authentication.getPrincipal());
        String secretKey = String.valueOf(authentication.getCredentials());

        if (clientId == null || !clientId.equals(apiClientId) || secretKey == null || !secretKey.equals(apiAuthSecret)) {
            throw new BadCredentialsException("Bad Request Header Credentials");
        }

        return new PreAuthenticatedAuthenticationToken(clientId, secretKey, new ArrayList<>());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(PreAuthenticatedAuthenticationToken.class);
    }
}