package org.adani.starbuck.data.core.sources.auth;

import java.util.HashMap;

/**
 * Specify the authentication mechanism to
 * a protected resource.
 */
public enum AuthenticationType {

    BASIC(new AuthenticationMeta(new HashMap<>()));

    private final AuthenticationMeta authenticationMeta;

    AuthenticationType (AuthenticationMeta authenticationMeta){
        this.authenticationMeta = authenticationMeta;
    }

    public AuthenticationMeta getAuthenticationMeta() {
        return authenticationMeta;
    }
}
