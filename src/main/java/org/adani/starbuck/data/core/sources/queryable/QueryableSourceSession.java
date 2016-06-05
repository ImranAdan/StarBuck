package org.adani.starbuck.data.core.sources.queryable;


import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Collections;
import java.util.Map;

public abstract class QueryableSourceSession {

    private final Map<String, Object> sessionMeta;
    private final QueryableInitialisationConfig queryableInitialisationConfig;

    protected QueryableSourceSession(QueryableInitialisationConfig queryableInitialisationConfig) {
        this.queryableInitialisationConfig = queryableInitialisationConfig;
        this.sessionMeta = Collections.emptyMap();
    }

    public QueryableInitialisationConfig getQueryableInitialisationConfig() {
        return queryableInitialisationConfig;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }

    public Map<String, Object> getSessionMeta() {
        return sessionMeta;
    }
}
