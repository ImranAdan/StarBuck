package org.adani.starbuck.data.core.sources.queryable;


import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class QueryableSourceSession {

    private final Map<String, Object> sessionMeta;
    private final QueryableInitialisationConfiguration queryableInitialisationConfiguration;

    protected QueryableSourceSession(QueryableInitialisationConfiguration queryableInitialisationConfiguration) {
        this.queryableInitialisationConfiguration = queryableInitialisationConfiguration;
        sessionMeta = new HashMap<>();
    }

    public QueryableInitialisationConfiguration getQueryableInitialisationConfiguration() {
        return queryableInitialisationConfiguration;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }

    public Map<String, Object> getSessionMeta() {
        return sessionMeta;
    }
}
