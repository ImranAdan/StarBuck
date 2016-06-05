package org.adani.starbuck.data.core.sources.security;

import java.util.Map;

public class AuthenticationMeta {

    private final Map<String, Object> authenticationParameters;

    public AuthenticationMeta(Map<String, Object> authenticationParameters) {
        this.authenticationParameters = authenticationParameters;
    }

    public Map<String, Object> getAuthenticationParameters() {
        return authenticationParameters;
    }
}
