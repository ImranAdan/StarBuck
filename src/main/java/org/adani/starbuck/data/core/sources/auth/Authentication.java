package org.adani.starbuck.data.core.sources.auth;

public interface Authentication<T extends AuthenticationType> {


    AuthenticationMeta getAuthenticationMetaData();
}
