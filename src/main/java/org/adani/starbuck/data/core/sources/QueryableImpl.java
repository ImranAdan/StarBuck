package org.adani.starbuck.data.core.sources;

import org.adani.starbuck.data.core.sources.auth.Authentication;
import org.adani.starbuck.data.core.sources.auth.AuthenticationType;

import java.net.URL;

public class QueryableImpl implements Queryable {

    private final QueryableSourceType queryableType;
    private final URL queryableSourceURL;
    private final Authentication authentication;

    public QueryableImpl(QueryableSourceType queryableType, URL queryableSourceURL, Authentication authenticationType) {
        this.queryableType = queryableType;
        this.queryableSourceURL = queryableSourceURL;
        this.authentication = authenticationType;
    }


    @Override
    public QueryableSourceSession getQueryableSourceSession() {
        return null;
    }
}
