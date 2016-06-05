package org.adani.starbuck.data.core.sources.security;

public interface Authentication<T extends AuthenticationType> {


    AuthenticationMeta getAuthenticationMetaData();
}
